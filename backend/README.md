Credit: https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey

``$ curl localhost:8080/dit126/api/users``
``{"users":[{"name":"johan"},{"name":"adam"},{"name":"gustav"},{"name":"robin"}]}``

``$ curl -d "username=johan&password=12345" -H "Content-Type: application/x-www-form-urlencoded" -X POST localhost:8080/dit126/api/auth``

``eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkaXQxMjYiLCJ1c2VybmFtZSI6ImpvaGFuIn0.zNDy5ijAJPD2-pl0KZOXW8HHrUirKvuU0o_976MgT5s``

``$ curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkaXQxMjYiLCJ1c2VybmFtZSI6ImpvaGFuIn0.zNDy5ijAJPD2-pl0KZOXW8HHrUirKvuU0o_976MgT5s" -X GET localhost:8080/dit126/api/users``

``{"users":[{"name":"johan"},{"name":"adam"},{"name":"gustav"},{"name":"robin"}]}``