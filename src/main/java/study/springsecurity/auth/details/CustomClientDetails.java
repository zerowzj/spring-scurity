package study.springsecurity.auth.details;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomClientDetails implements ClientDetails {

    /* 客户端ID */
    private String clientId = "client1";
    /* 客户端密钥 */
    private String clientSecret = "{noop}client1";
    /* 会话 */
    private Set<String> scopes = Sets.newHashSet("user_info");
    /* 授权类型 */
    private Set<String> authorizedGrantTypes = Sets.newHashSet("authorization_code", "refresh_token");
    /* 跳转uri */
    private Set<String> redirectUri  = Sets.newHashSet("http://127.0.0.1:9100/client1/login", "http://127.0.0.1:9200/client2/login");
    /* 是否自动批准 */
    private boolean isAutoApprove = false;

    public CustomClientDetails() {
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return this.scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.redirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 30;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 30;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return this.isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
