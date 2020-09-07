# Fraud-Detection-Service

As its name suggests, this service is responsible for screening new transactions and checking for fraud, based on historical aggregated data. The application must expose a REST API. It should contain endpoint to:
  - Screen a transaction for fraud

#### Build
 - Run `mvn clean install` in the `fraud-detection` directory where the pom.xml resides.
 - A jar will be created in the target folder `fraud-detection/target`.
 - The next step is to create a docker image for this service.
 - Run `docker build -t fraud-detection ./` inside the `fraud-detection` folder where the Dockerfile resides.
 
#### Deployment
 - Run `docker run --detach --name fraud-detection-service --publish=8080:8080 fraud-detection-service:latest` to start the container.
 - Run `docker stop fraud-detection-service` to stop the container.
 

#### Testing

##### Case 1:
```
- Transaction

{
  "amount": 100,
  "billingName": "Customer4",
  "customerId": 4
}
```
```
- Response

[] 
```

##### Case 2:
```
- Transaction

{
  "amount": 105,
  "billingName": "Customer1",
  "customerId": 1
}
```
```
- Response

[
  {
    "message": "Daily transaction amount crossed.",
    "field": "amount"
  },
  {
    "message": "Daily transaction frequency crossed.",
    "field": "frequency"
  }
]
```
##### Case 3:
```
- Transaction

{
  "amount": 100,
  "billingName": "Customer3",
  "customerId": 3
}
```
```
- Response

[
  {
    "message": "Monthly transaction frequency crossed.",
    "field": "frequency"
  },
  {
    "message": "Daily transaction amount crossed.",
    "field": "amount"
  }
]
```
##### Case 4:

```
- Transaction

{
  "amount": 100,
  "billingName": "Customer1",
  "customerId": 1
}
```
```
- Response

[
  {
    "message": "Daily transaction frequency crossed.",
    "field": "frequency"
  }
]
```

##### Case 5:
```
- Transaction

{
  "amount": 120,
  "billingName": "Customer4",
  "customerId": 4
}
```
```
- Response

[
  {
    "message": "The amount specified in the transaction is more the average amount spent by this customer monthly.",
    "field": "amount"
  }
]
```
##### Case 6:
```
- Transaction

{
  "amount": 1000,
  "billingName": "Customer1",
  "customerId": 3
}
```
```
- Response

[
  {
    "message": "Billing Name does not match with registered customer name.",
    "field": "billingName"
  },
  {
    "message": "Monthly transaction frequency crossed.",
    "field": "frequency"
  },
  {
    "message": "Daily transaction amount crossed.",
    "field": "amount"
  }
]
```

#### First level architecture design

![First level architecture design](src/main/resources/static/first_level_design.png)
