package com.nazar.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.nazar.util.ENVNAME
import com.nazar.util.getEnvironmentVariable
import com.nazar.util.getEnvironmentVariableOrNull
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    val secret = if (getEnvironmentVariableOrNull(ENVNAME.JWT_SECRET) == null) {
        environment.config.property("jwt.secret").getString()
    } else {
        getEnvironmentVariable(ENVNAME.JWT_SECRET)
    }


    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val myRealm = environment.config.property("jwt.realm").getString()

    authentication {
        jwt {
            realm = myRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(secret))
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(audience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
