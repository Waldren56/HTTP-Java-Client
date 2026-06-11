# Java HTTP Client - GET and POST

Java tutorial project to learn how to communicate with a REST API using `HttpClient`, `HttpRequest`, and `HttpResponse`.

The program sends HTTP requests to [JSONPlaceholder](https://jsonplaceholder.typicode.com/), a free online service used to test API calls.

## What it does

- Makes a `POST` request to `/posts`, sending a JSON payload.
- Prints the status code and response body to the console.
- Makes a `GET` request to `/posts/3`.
- Checks the response status code.
- Handles any network errors with `try/catch`.

## Technologies Used

- Java 21
- Java HTTP Client
- JSONPlaceholder API
- IntelliJ IDEA

## Structure

```text
src/
└── Main.java
```

## How to Clone the Project

To download this project on your device, open the terminal and run:

```bash
git clone https://github.com/Waldren56/HTTP-Java-Client.git
```

Then enter the project folder:

```bash
cd HTTP-Java-Client
```

## How to Run It

From the terminal, in the project folder:

```bash
javac src/Main.java
java -cp src Main
```

Or run `Main.java` directly from IntelliJ IDEA.

## Example Output

```text
https://jsonplaceholder.typicode.com/
Status Code: 201
Response Body:
{
"id": 101
}
{
"userId": 1,
"id": 3,
"title": "...",
"body": "..."
}
Payload received successfully!
```

## Note

JSONPlaceholder simulates the creation of new resources. When a `POST` request is executed, the server responds as if it had created a new item, but the data is not actually saved permanently.

## Learning Objective

This project helps you understand the basics of HTTP communication in Java:

- the difference between `GET` and `POST`;
- creating an HTTP request;
- sending JSON to a server;
- reading the response;
- checking status codes;
- handling network errors.
