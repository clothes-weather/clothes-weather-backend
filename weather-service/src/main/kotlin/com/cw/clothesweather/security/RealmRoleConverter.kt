package com.cw.clothesweather.security

import org.springframework.core.convert.converter.Converter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt


class RealmRoleConverter : Converter<Jwt, Collection<GrantedAuthority>> {

    override fun convert(jwt: Jwt): Collection<GrantedAuthority>? {
        val realmAccess: Map<String, List<String>> = jwt.claims["realm_access"] as Map<String, List<String>>

        return realmAccess["roles"]
            ?.map { roleName -> "ROLE_$roleName" }
            ?.map { role: String? -> SimpleGrantedAuthority(role) }
    }

}