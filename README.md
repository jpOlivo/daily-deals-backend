# Daily Deals - Backend
This app is implemented on Spring Boot and exposes (both __protected__ and __unprotected__) REST services in order to consumed by an Angular app ([Daily Deals app](https://github.com/jpOlivo/daily-deals-frontend)).

We implemented __token-based authentication__ with [Auth0](https://auth0.com/) in order to protect some resources of our API. On the other hand, the data used by app are simply mocks.

This implementation was developed following a [tutorial](https://auth0.com/blog/angular-2-authentication/) from [@kukicado](https://twitter.com/kukicado)


## API Rest
This API offers both a public and a private endpoint. Only who have authority will be able access to the protected resources on the private endpoint.

![img](https://i.imgur.com/srXDdBy.png)

There is a docs of this API available in [http://localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)



## Running the app
From Eclipse IDE `com.example.DealsApp -> Run As -> Java Application`

## Invoking services

1- Get __/api/deals/public__

```
c:\>curl http://localhost:8080/api/deals/public 

[{"id":1234,"name":"Galaxy Note 7","description":"The Note 7 has been fixed and will no longer explode. Get it an amazing price!","originalPrice":899.99,"salePrice":499.99},{"id":2016,"name":"Macbook Pro 2016","description":"The Mac Book Pro is the de-facto standard for best in breed mobile computing.","originalPrice":2199.99,"salePrice":1999.99},{"id":4444,"name":"GoPro 4","description":"Record yourself in first person 24/7 with the GoPro 4. Show everyone how exciting your life is.","originalPrice":299.99,"salePrice":199.99}]
```

2- Get __/api/deals/private__

* Authenticated with scopes [openid, profile, email, __read:deals__]

```
c:\>curl  --request GET \
		  --url http://localhost:8080/api/deals/private/ \
		  --header "authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5FVkZRVGc0TXpjNU5URkdSVEJHT0VZMk5qZERSamN5UkVaRk5qQkZORFk1T1RSRU5qQkRNQSJ9.eyJpc3MiOiJodHRwczovL2pwLW9saXZvLmF1dGgwLmNvbS8iLCJzdWIiOiJnb29nbGUtb2F1dGgyfDExNjI1ODA1MDM2NTUyOTg5ODMxMiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL2pwLW9saXZvLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE1MzE5Mzk3MzcsImV4cCI6MTUzMTk0NjkzNywiYXpwIjoib2lXUXQwS2RaRURMU1BIU3FoRHFxUk5vZUJPQ3R2M1IiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIHJlYWQ6ZGVhbHMifQ.J4WNSiDGvusqVTDpG3SND6jNL-Vv6-wzJQa3iuLsQn6jiqUylIvmJ53CWPhWRLoJAgKDLwOrDO47foCELQs3h8UHE5AgsnJByDEilcpnEsi0D2W5IXJA5FpsLYAal3cop-shIA29RzNtan1dkZBuN5aeRdghCKmoiI8KSVuPYiYSQeedmu-no_YuoHBtQDRZWiZMfHOYxw-qjOtKiwyppOFLNBPkO2iaPI-eTWF8zE_r_MC9VcnlL5wClepkgrx9oY1z2QMrv4jbzMLTLJz_vJk-ITe1HbVpz8ltpWlAlwD3RlQdBv0sa8XCD7lT4qPsqLlnx1n55Diy00xLIjnLPg"

[{"id":5678,"name":"Amazon Echo","description":"Turn your home into smart home w
ith Amazon Echo. Just say the word and Echo will do it.","originalPrice":179.99,
"salePrice":129.99}]
```

* No authenticated (Expiration token or not token)

```
c:\>curl  --request GET \
		  --url http://localhost:8080/api/deals/private/ \
		  --header "authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5FVkZRVGc0TXpjNU5URkdSVEJHT0VZMk5qZERSamN5UkVaRk5qQkZORFk1T1RSRU5qQkRNQSJ9.eyJpc3MiOiJodHRwczovL2pwLW9saXZvLmF1dGgwLmNvbS8iLCJzdWIiOiJnb29nbGUtb2F1dGgyfDExNjI1ODA1MDM2NTUyOTg5ODMxMiIsImF1ZCI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJodHRwczovL2pwLW9saXZvLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE1MzE4Mzk0MTIsImV4cCI6MTUzMTg0NjYxMiwiYXpwIjoib2lXUXQwS2RaRURMU1BIU3FoRHFxUk5vZUJPQ3R2M1IiLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIHJlYWQ6ZGVhbHMifQ.VReod1pd_YeeKsWbSrNOdkCCr7PYqoKcXgvNVavlN-icfue35XpXEYTitnatvCQLl-t83OyQQpqCYhKMdPZ6pxevoEmSVF_hRZYub4t3oajttLRcgzG9B3zuE6oNIaQaKYscMFUuGcii0lSOUbrr3vwng4Ws4geyemE_Dh9Tkk9pHXAD6EraJ0XZ4QQ32xKrSpLKJws8Roixg50YkQtMz7_pK9_ZVfolKVkhrwqpvtg3jrZCayrhk8KJehf-VVQqHzvKl9y1zT4BMjk4D9ne5qPYqEPZkMHjVLv9_7q5Hnik5tj3VA0zgOsx6cu8kNBZa0EgYaj_bxqIXtWLaBrZfQ"

{"timestamp":"2018-07-18T19:02:14.369+0000","status":401,"error":"Unauthorized",
"message":"Unauthorized","path":"/api/deals/private"}
```

* Authenticated with scopes []

```
c:\>curl  --request GET \
		  --url http://localhost:8080/api/deals/private/ \
		  --header "authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5FVkZRVGc0TXpjNU5URkdSVEJHT0VZMk5qZERSamN5UkVaRk5qQkZORFk1T1RSRU5qQkRNQSJ9.eyJpc3MiOiJodHRwczovL2pwLW9saXZvLmF1dGgwLmNvbS8iLCJzdWIiOiJvaVdRdDBLZFpFRExTUEhTcWhEcXFSTm9lQk9DdHYzUkBjbGllbnRzIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwIiwiaWF0IjoxNTMxOTM5OTA1LCJleHAiOjE1MzIwMjYzMDUsImF6cCI6Im9pV1F0MEtkWkVETFNQSFNxaERxcVJOb2VCT0N0djNSIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.iA2Ne7vhZVvvpR026_UyTzD7otnsoBrlb4MwhuQXq7jD9NRM-AdHj5MhKMx8KqxBFZ2hlUOksU-XnKh1uP09FjNIWIWNhn-mAkp8WWxWQff3leZE494gi5Rb_iXr17hrvunjUZHLe2j-1ayrovtgWMZJYtTiudWpSalt6ADuJ1smJyIKBRj3i1-FAU6iLocT68micPkuxKSf7WNZktiNlTJbymWpDbenNBYpShVfu0QhFd7aHWjIorpak51GjqpZ51adzrsNDixqbZKjk2nZS4yAUGf-D2VVmDeAeKYSbLwu_O7IFdlFz87qhlyzP6GPCU0ujIqaVdkfZi42TrE6XA"

{"timestamp":"2018-07-18T19:04:30.334+0000","status":403,"error":"Forbidden","me
ssage":"Forbidden","path":"/api/deals/private/"}
```  


