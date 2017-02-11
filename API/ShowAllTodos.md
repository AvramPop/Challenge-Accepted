**Show all todos**
----
  Returns json data about every todo in the db.

* **URL**

  /api/todo/findall

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
  None

* **Data Params**

  Noone
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
       
                    `{
                      "id": "589cbbe52abb5f29e5cde67c",
                      "description": "dani",
                      "title": "asddfgd"
                    }, 
                    {
                      "id": "589dcba82abb5f193d9efe32",
                      "description": "todo",
                      "title": "testishishish"
                    }
                  ]`
 
* **Error Response:**

  None

* **Sample Call:**
<br />Postman:

  <br />Header: " Content-Type: application/json "
  <br /> URL: "/api/todo/findall"
  <br /> Body: -