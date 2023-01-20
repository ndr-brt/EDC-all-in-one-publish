rootProject.name = "connector"

// this is needed to have access to snapshot builds of plugins
pluginManagement {
    repositories {
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
        mavenLocal()
    }
    versionCatalogs {
        create("libs") {
            from("org.eclipse.edc:edc-versions:0.0.1-SNAPSHOT")
            // this is not part of the published EDC Version Catalog, so we'll just "amend" it
            library("dnsOverHttps", "com.squareup.okhttp3", "okhttp-dnsoverhttps").versionRef("okhttp")
            version("picocli", "4.6.3")
            version("googleFindBugs", "3.0.2")
            version("openApiTools", "0.2.1")

            library("swagger-jaxrs", "io.swagger.core.v3", "swagger-jaxrs2-jakarta").version("2.1.13")
            version("swaggerAnnotation", "1.5.22")


            library("picocli-core", "info.picocli", "picocli").versionRef("picocli")
            library("picocli-codegen", "info.picocli", "picocli-codegen").versionRef("picocli")
            library("google-findbugs-jsr305", "com.google.code.findbugs", "jsr305").versionRef("googleFindBugs")
            library(
                "openapi-jackson-databind-nullable",
                "org.openapitools",
                "jackson-databind-nullable"
            ).versionRef("openApiTools")
            library("swagger-annotations", "io.swagger", "swagger-annotations").versionRef("swaggerAnnotation")

        }
        create("identityHub") {
            version("ih", "0.0.1-SNAPSHOT")
            library("spi-core", "org.eclipse.edc", "identity-hub-spi").versionRef("ih")
            library("core", "org.eclipse.edc", "identity-hub").versionRef("ih")
            library("core-api", "org.eclipse.edc", "identity-hub-api").versionRef("ih")
            library("core-client", "org.eclipse.edc", "identity-hub-client").versionRef("ih")
            library("core-verifier", "org.eclipse.edc", "identity-hub-credentials-verifier").versionRef("ih")

            library(
                "ext-verifier-jwt", "org.eclipse.edc", "identity-hub-verifier-jwt"
            ).versionRef("ih")
            library(
                "ext-credentials-jwt", "org.eclipse.edc", "identity-hub-credentials-jwt"
            ).versionRef("ih")

        }
        create("edc") {
            version("edc", "0.0.1-SNAPSHOT")
            library("util", "org.eclipse.edc", "util").versionRef("edc")
            library("boot", "org.eclipse.edc", "boot").versionRef("edc")
            library("config-filesystem", "org.eclipse.edc", "configuration-filesystem").versionRef("edc")
            library("junit", "org.eclipse.edc", "junit").versionRef("edc")


            library("spi-core", "org.eclipse.edc", "core-spi").versionRef("edc")
            library("spi-policy-engine", "org.eclipse.edc", "policy-engine-spi").versionRef("edc")
            library("spi-transaction", "org.eclipse.edc", "transaction-spi").versionRef("edc")
            library("spi-transaction-datasource", "org.eclipse.edc", "transaction-datasource-spi").versionRef("edc")
            library("spi-identity-did", "org.eclipse.edc", "identity-did-spi").versionRef("edc")
            library("spi-catalog", "org.eclipse.edc", "catalog-spi").versionRef("edc")
            library("spi-web", "org.eclipse.edc", "web-spi").versionRef("edc")

            library("core-connector", "org.eclipse.edc", "connector-core").versionRef("edc")
            library("core-controlPlane", "org.eclipse.edc", "control-plane-core").versionRef("edc")
            library("core-micrometer", "org.eclipse.edc", "micrometer-core").versionRef("edc")
            library("core-api", "org.eclipse.edc", "api-core").versionRef("edc")
            library("core-identity-did", "org.eclipse.edc", "identity-did-core").versionRef("edc")
            library("core-stateMachine", "org.eclipse.edc", "state-machine").versionRef("edc")
            library("core-sql", "org.eclipse.edc", "sql-core").versionRef("edc")
            library("core-junit", "org.eclipse.edc", "junit").versionRef("edc")
            library("core-jetty", "org.eclipse.edc", "jetty-core").versionRef("edc")
            library("core-jersey", "org.eclipse.edc", "jersey-core").versionRef("edc")

            library("ext-identity-did-crypto", "org.eclipse.edc", "identity-did-crypto").versionRef("edc")
            library("ext-identity-did-core", "org.eclipse.edc", "identity-did-core").versionRef("edc")
            library("ext-identity-did-web", "org.eclipse.edc", "identity-did-web").versionRef("edc")
            library("ext-http", "org.eclipse.edc", "http").versionRef("edc")
            library("ext-micrometer-jetty", "org.eclipse.edc", "jetty-micrometer").versionRef("edc")
            library("ext-micrometer-jersey", "org.eclipse.edc", "jersey-micrometer").versionRef("edc")
            library("ext-observability", "org.eclipse.edc", "api-observability").versionRef("edc")
            library("ext-configuration-filesystem", "org.eclipse.edc", "configuration-filesystem").versionRef("edc")
            library("ext-vault-filesystem", "org.eclipse.edc", "vault-filesystem").versionRef("edc")
            library("ext-vault-azure", "org.eclipse.edc", "vault-azure").versionRef("edc")
            library("ext-azure-cosmos-core", "org.eclipse.edc", "azure-cosmos-core").versionRef("edc")
            library("ext-azure-test", "org.eclipse.edc", "azure-test").versionRef("edc")
            library("ext-jdklogger", "org.eclipse.edc", "monitor-jdk-logger").versionRef("edc")


            library("api-management-config", "org.eclipse.edc", "management-api-configuration").versionRef("edc")
            library("api-management", "org.eclipse.edc", "management-api").versionRef("edc")
            library("api-observability", "org.eclipse.edc", "api-observability").versionRef("edc")
            library("spi-ids", "org.eclipse.edc", "ids-spi").versionRef("edc")
            library("ids", "org.eclipse.edc", "ids").versionRef("edc")
            library("iam-mock", "org.eclipse.edc", "iam-mock").versionRef("edc")

            // DPF modules
            library("dpf-transferclient", "org.eclipse.edc", "data-plane-transfer-client").versionRef("edc")
            library("dpf-selector-client", "org.eclipse.edc", "data-plane-selector-client").versionRef("edc")
            library("dpf-selector-spi", "org.eclipse.edc", "data-plane-selector-spi").versionRef("edc")
            library("dpf-selector-core", "org.eclipse.edc", "data-plane-selector-core").versionRef("edc")
            library("dpf-framework", "org.eclipse.edc", "data-plane-framework").versionRef("edc")


//            bundle(
//                "connector",
//                listOf("boot", "core-connector", "core-jersey", "core-controlplane", "api-observability")
//            )
//
//            bundle(
//                "dpf",
//                listOf(
//                    "dpf-transferclient",
//                    "dpf-selector-client",
//                    "dpf-selector-spi",
//                    "dpf-selector-core",
//                    "dpf-framework"
//                )
//            )
        }
    }
}

include("plugins:module-names")
include("plugins:test-summary")
include("plugins:openapi-merger")
include("plugins:edc-build")
include("plugins:autodoc:autodoc-plugin")
include("plugins:autodoc:autodoc-processor")
include("runtime-metamodel")
include("version-catalog")
include(":Connector:core:common:connector-core")
include(":Connector:core:common:boot")
include(":Connector:core:common:jwt-core")
include(":Connector:core:common:policy-engine")
include(":Connector:core:common:policy-evaluator")
include(":Connector:core:common:state-machine")
include(":Connector:core:common:util")
include(":Connector:core:common:junit")
include(":Connector:core:control-plane:contract-core")
include(":Connector:core:control-plane:control-plane-core")
include(":Connector:core:control-plane:control-plane-aggregate-services")
include(":Connector:core:control-plane:transfer-core")
include(":Connector:core:control-plane:control-plane-api")
include(":Connector:core:control-plane:control-plane-api-client")
include(":Connector:core:data-plane:data-plane-util")
include(":Connector:core:data-plane:data-plane-core")
include(":Connector:core:data-plane:data-plane-framework")
include(":Connector:core:data-plane-selector:data-plane-selector-core")
include(":Connector:data-protocols:ids:ids-api-configuration")
include(":Connector:data-protocols:ids:ids-api-multipart-endpoint-v1")
include(":Connector:data-protocols:ids:ids-api-multipart-dispatcher-v1")
include(":Connector:data-protocols:ids:ids-core")
include(":Connector:data-protocols:ids:ids-jsonld-serdes")
include(":Connector:data-protocols:ids:ids-spi")
include(":Connector:data-protocols:ids:ids-token-validation")
include(":Connector:data-protocols:ids:ids-transform-v1")
include(":Connector:extensions:common:api:api-core")
include(":Connector:extensions:common:api:api-observability")
include(":Connector:extensions:common:auth:auth-basic")
include(":Connector:extensions:common:auth:auth-tokenbased")
include(":Connector:extensions:common:aws:aws-s3-test")
include(":Connector:extensions:common:aws:aws-s3-core")
include(":Connector:extensions:common:azure:azure-eventgrid")
include(":Connector:extensions:common:azure:azure-resource-manager")
include(":Connector:extensions:common:azure:azure-test")
include(":Connector:extensions:common:azure:azure-blob-core")
include(":Connector:extensions:common:azure:azure-cosmos-core")
include(":Connector:extensions:common:configuration:configuration-filesystem")
include(":Connector:extensions:common:events:events-cloud-http")
include(":Connector:extensions:common:gcp:gcp-core")
include(":Connector:extensions:common:http")
include(":Connector:extensions:common:http:jersey-core")
include(":Connector:extensions:common:http:jersey-micrometer")
include(":Connector:extensions:common:http:jetty-core")
include(":Connector:extensions:common:http:jetty-micrometer")
include(":Connector:extensions:common:iam:decentralized-identity")
include(":Connector:extensions:common:iam:decentralized-identity:identity-did-test")
include(":Connector:extensions:common:iam:decentralized-identity:identity-did-core")
include(":Connector:extensions:common:iam:decentralized-identity:identity-did-crypto")
include(":Connector:extensions:common:iam:decentralized-identity:identity-did-service")
include(":Connector:extensions:common:iam:decentralized-identity:identity-did-web")
include(":Connector:extensions:common:iam:iam-mock")
include(":Connector:extensions:common:iam:oauth2:oauth2-daps")
include(":Connector:extensions:common:iam:oauth2:oauth2-core")
include(":Connector:extensions:common:iam:oauth2:oauth2-client")
include(":Connector:extensions:common:iam:oauth2:oauth2-service")
include(":Connector:extensions:common:metrics:micrometer-core")
include(":Connector:extensions:common:monitor:monitor-jdk-logger")
include(":Connector:extensions:common:sql:sql-core")
include(":Connector:extensions:common:sql:sql-lease")
include(":Connector:extensions:common:sql:sql-pool:sql-pool-apache-commons")
include(":Connector:extensions:common:transaction")
include(":Connector:extensions:common:transaction:transaction-atomikos")
include(":Connector:extensions:common:transaction:transaction-local")
include(":Connector:extensions:common:vault:vault-azure")
include(":Connector:extensions:common:vault:vault-filesystem")
include(":Connector:extensions:common:vault:vault-hashicorp")
include(":Connector:extensions:common:api:control-api-configuration")
include(":Connector:extensions:common:api:management-api-configuration")
include(":Connector:extensions:control-plane:api:management-api")
include(":Connector:extensions:control-plane:api:management-api:asset-api")
include(":Connector:extensions:control-plane:api:management-api:catalog-api")
include(":Connector:extensions:control-plane:api:management-api:contract-agreement-api")
include(":Connector:extensions:control-plane:api:management-api:contract-definition-api")
include(":Connector:extensions:control-plane:api:management-api:contract-negotiation-api")
include(":Connector:extensions:control-plane:api:management-api:policy-definition-api")
include(":Connector:extensions:control-plane:api:management-api:transfer-process-api")
include(":Connector:extensions:control-plane:transfer:transfer-data-plane")
include(":Connector:extensions:control-plane:transfer:transfer-pull-http-receiver")
include(":Connector:extensions:control-plane:transfer:transfer-pull-http-dynamic-receiver")
include(":Connector:extensions:control-plane:provision:provision-blob")
include(":Connector:extensions:control-plane:provision:provision-gcs")
include(":Connector:extensions:control-plane:provision:provision-http")
include(":Connector:extensions:control-plane:provision:provision-aws-s3")
include(":Connector:extensions:control-plane:provision:provision-oauth2:provision-oauth2-core")
include(":Connector:extensions:control-plane:provision:provision-oauth2:provision-oauth2")
include(":Connector:extensions:control-plane:store:cosmos:asset-index-cosmos")
include(":Connector:extensions:control-plane:store:cosmos:contract-definition-store-cosmos")
include(":Connector:extensions:control-plane:store:cosmos:contract-negotiation-store-cosmos")
include(":Connector:extensions:control-plane:store:cosmos:control-plane-cosmos")
include(":Connector:extensions:control-plane:store:cosmos:policy-definition-store-cosmos")
include(":Connector:extensions:control-plane:store:cosmos:transfer-process-store-cosmos")
include(":Connector:extensions:control-plane:store:sql:asset-index-sql")
include(":Connector:extensions:control-plane:store:sql:contract-definition-store-sql")
include(":Connector:extensions:control-plane:store:sql:contract-negotiation-store-sql")
include(":Connector:extensions:control-plane:store:sql:control-plane-sql")
include(":Connector:extensions:control-plane:store:sql:policy-definition-store-sql")
include(":Connector:extensions:control-plane:store:sql:transfer-process-store-sql")
include(":Connector:extensions:data-plane:data-plane-api")
include(":Connector:extensions:data-plane:data-plane-client")
include(":Connector:extensions:data-plane:data-plane-azure-storage")
include(":Connector:extensions:data-plane:data-plane-azure-data-factory")
include(":Connector:extensions:data-plane:data-plane-http")
include(":Connector:extensions:data-plane:data-plane-aws-s3")
include(":Connector:extensions:data-plane:data-plane-google-storage")
include(":Connector:extensions:data-plane:data-plane-integration-tests")
include(":Connector:extensions:data-plane:store:sql:data-plane-store-sql")
include(":Connector:extensions:data-plane:store:cosmos:data-plane-store-cosmos")
include(":Connector:extensions:data-plane-selector:data-plane-selector-api")
include(":Connector:extensions:data-plane-selector:data-plane-selector-client")
include(":Connector:extensions:data-plane-selector:store:sql:data-plane-instance-store-sql")
include(":Connector:extensions:data-plane-selector:store:cosmos:data-plane-instance-store-cosmos")
include(":Connector:spi:common:auth-spi")
include(":Connector:spi:common:catalog-spi")
include(":Connector:spi:common:core-spi")
include(":Connector:spi:common:identity-did-spi")
include(":Connector:spi:common:http-spi")
include(":Connector:spi:common:jwt-spi")
include(":Connector:spi:common:oauth2-spi")
include(":Connector:spi:common:policy-engine-spi")
include(":Connector:spi:common:policy-model")
include(":Connector:spi:common:aggregate-service-spi")
include(":Connector:spi:common:transaction-datasource-spi")
include(":Connector:spi:common:transaction-spi")
include(":Connector:spi:common:transform-spi")
include(":Connector:spi:common:web-spi")
include(":Connector:spi:control-plane:contract-spi")
include(":Connector:spi:control-plane:control-plane-spi")
include(":Connector:spi:control-plane:transfer-data-plane-spi")
include(":Connector:spi:control-plane:policy-spi")
include(":Connector:spi:control-plane:transfer-spi")
include(":Connector:spi:control-plane:control-plane-api-client-spi")
include(":Connector:spi:data-plane:data-plane-spi")
include(":Connector:spi:data-plane-selector:data-plane-selector-spi")
include(":IdentityHub:spi:identity-hub-spi")
include(":IdentityHub:spi:identity-hub-store-spi")
include(":IdentityHub:spi:identity-hub-client-spi")
include(":IdentityHub:core:identity-hub")
include(":IdentityHub:core:identity-hub-client")
include(":IdentityHub:core:identity-hub-verifier")
include(":IdentityHub:extensions:store:sql:identity-hub-store-sql")
include(":IdentityHub:extensions:store:cosmos:identity-hub-store-cosmos")
include(":IdentityHub:extensions:identity-hub-api")
include(":IdentityHub:extensions:identity-hub-verifier-jwt")
include(":IdentityHub:extensions:credentials:identity-hub-credentials-jwt")
include("extensions:identity-hub-verifier-jwt")
include(":RegistrationService:spi:participant-store-spi")
include(":RegistrationService:spi:dataspace-authority-spi")
include(":RegistrationService:extensions:registration-service")
include(":RegistrationService:extensions:participant-verifier")
include(":RegistrationService:extensions:registration-policy-gaiax-member")
include(":RegistrationService:extensions:store:sql:participant-store-sql")
include(":RegistrationService:extensions:store:cosmos:participant-store-cosmos")
include(":FederatedCatalog:core:federated-catalog")
include(":FederatedCatalog:extensions:store:fcc-node-directory-cosmos")
include(":FederatedCatalog:extensions:api:federated-catalog-api")
include(":FederatedCatalog:spi:federated-catalog-spi")
