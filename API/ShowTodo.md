**Show Todo**
----
  Returns json data about a single Todo.

* **URL**

  /api/todo/findone/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[String]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** <br />`{
                    "id": "589c5e322abb5f28631ef2cc",
                    "description": "todotest",
                    "title": "titlesmeherishishishishish"
                  }`
 
* **Error Response:**

  NOT YET DEFINED

* **Sample Call:**

  <br />Header: " Content-Type: application/json "
    <br /> URL: "/api/todo/findone/:id"
    <br /> Body: -