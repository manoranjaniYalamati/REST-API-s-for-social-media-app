# introtucetasks

TO CREATE THE USERS: POST: localhost:8080/users

TO GET THE USERS DETAILS: GET: localhost:8080/users

TO CREATE A STATUS: POST: localhost:8080/status


BODY: 1)file-video/image file         2)statusRequest-{"userId":"609166456cc50f71f0a07f19", "title":"HELLO", "description":"girl is pretty"}

TO CREATE A COMMENT:POST:localhost:8080/comment



BODY: raw:  {
    "userId": "609113789c474c1fbb198ad6",
    "statusId":"609113c19c474c1fbb198add",
    "comment":"This is looking too cute naaa"
}
TO GET STATUSES: GET:localhost:8080/status/{userid}


PARAMS: 1)index-0
        2)offset-2
      
