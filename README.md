# Spring Security Config

## Summarize
This repo has a hexagonal architecture project that implements Spring Security 
with JWT validation. 

The main idea is that you can use this repository as reference for a new 
project where you have to implement security on a hexagonal architecture project. 
In order to do this, you have to link a database to implement the security 
entities and repositories.

## Endpoints

### POST /auth/login
You have to call this endpoint with a body like it:
```
{
    "username": "admin",
    "password": "admin"
}
```

### POST /auth/signup
You have to call this endpoint with a body like it:
```
{
    "username": "admin1",
    "password": "admin1",
    "roleRequest": {
        "roleListName": [
            "ADMIN"
        ]
    }
}
```

### Examples endpoints:
- /ping: public endpoint
- /hello: private endpoint

The configuration of new endpoints is on `com/alejua39/scaffoldings/infrastructure/auth/configs/SecurityConfig.java` file.


```
.authorizeHttpRequests(http -> {
    // Public endpoints
    http.requestMatchers(HttpMethod.GET, "/ping").permitAll();
    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();`

    // Private endpoints
    http.requestMatchers(HttpMethod.GET, "/hello").hasAnyRole("ADMIN", "BUYER");

    // Another endpoints
    http.anyRequest().denyAll();
})
```