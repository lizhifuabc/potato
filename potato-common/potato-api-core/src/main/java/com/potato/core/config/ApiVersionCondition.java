package com.potato.core.config;

import com.potato.core.annotation.ApiVersion;
import lombok.Data;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接口版本控制：重写相应的 RequestCondition
 *
 * @author lizhifu
 * @date 2021/9/14
 */
@Data
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    /**
     * 接口路径中的版本号前缀，如: api/v[1-n]/test
     */
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/v([0-9]+\\.{0,1}[0-9]{0,2})/");

    private ApiVersion apiVersion;

    ApiVersionCondition(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 最近优先原则，方法定义的 @ApiVersion > 类定义的 @ApiVersion
     * @param apiVersionCondition
     * @return
     */
    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    /**
     * 获得符合匹配条件的ApiVersionCondition
     * @param httpServletRequest
     * @return
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (m.find()) {
            double version = Double.valueOf(m.group(1));
            if (version >= getApiVersion().value()) {
                return this;
            }
        }
        return null;
    }

    /**
     * 当出现多个符合匹配条件的ApiVersionCondition，优先匹配版本号较大的
     * @param apiVersionCondition
     * @param httpServletRequest
     * @return
     */
    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion().value() >= getApiVersion().value() ? 1 : -1;
    }
    public ApiVersion getApiVersion() {
        return apiVersion;
    }
}
