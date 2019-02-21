``$ curl localhost:8080/api/users``

```json
{
    "_embedded" : {
      "users" : [ {
        "name" : "johan",
        "username" : null,
        "password" : null,
        "_links" : {
          "self" : {
            "href" : "http://localhost:8080/api/users/1"
          },
          "user" : {
            "href" : "http://localhost:8080/api/users/1"
          }
        }
      }, {
        "name" : "robin",
        "username" : null,
        "password" : null,
        "_links" : {
          "self" : {
            "href" : "http://localhost:8080/api/users/2"
          },
          "user" : {
            "href" : "http://localhost:8080/api/users/2"
          }
        }
      }, {
        "name" : "adam",
        "username" : null,
        "password" : null,
        "_links" : {
          "self" : {
            "href" : "http://localhost:8080/api/users/3"
          },
          "user" : {
            "href" : "http://localhost:8080/api/users/3"
          }
        }
      }, {
        "name" : "gustav",
        "username" : null,
        "password" : null,
        "_links" : {
          "self" : {
            "href" : "http://localhost:8080/api/users/4"
          },
          "user" : {
            "href" : "http://localhost:8080/api/users/4"
          }
        }
      } ]
    },
    "_links" : {
      "self" : {
        "href" : "http://localhost:8080/api/users{?page,size,sort}",
        "templated" : true
      },
      "profile" : {
        "href" : "http://localhost:8080/api/profile/users"
      }
    },
    "page" : {
      "size" : 20,
      "totalElements" : 4,
      "totalPages" : 1,
      "number" : 0
    }
  }
```