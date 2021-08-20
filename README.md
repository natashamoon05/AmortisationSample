# AmortisationSample
Sample Program for Amortisation Schedule

Build and Run Application:
1. Clone the main branch from Git Repository into your system
2. Load the project in Eclipse
3. Run the AmortisationDemoApplication.java to start application
4. Please use following API endpoints to communicate with the application
   
   a. Create the amortisation schedule for a provided set of loan details
   
      API Endpoint : localhost:8082/createAmotisationSchedule
   
      Method : POST
      
      Sample Request Body : {
      "costOfAssest": 25000,
      "deposit":5000,
      "yearlyRateOfInterest" :7.5,
      "noOfMonthlyPayments" : 12,
      "balloonPayment" : false,
      "balloonPaymentAmount" : 10000
      }
    
    b. Get List of previously created schedules :
        
      API Endpoint : localhost:8082/getAllSchedules
      
      Method : GET
      
      Sample Response Body : [
      {
        "loanId": "1",
        "costOfAssest": 25000.0,
        "deposit": 5000.0,
        "yearlyRateOfInterest": 7.5,
        "noOfMonthlyPayments": 12.0,
        "balloonPaymentAmount": 0.0,
        "totalInterestDue": 821.79,
        "totalPaymentsDue": 12.0,
        "balloonPayment": false
      },
      {
        "loanId": "2",
        "costOfAssest": 25000.0,
        "deposit": 5000.0,
        "yearlyRateOfInterest": 7.5,
        "noOfMonthlyPayments": 12.0,
        "balloonPaymentAmount": 10000.0,
        "totalInterestDue": 821.79,
        "totalPaymentsDue": 12.0,
        "balloonPayment": true
        }

      ]
  
     c. Retrieve the full details of an individual schedule
        
      API Endpoint : localhost:8082/getAmortisationSchedule?loanId=1
       
      Method : GET 
        
      Sample Response Body : {
        "loanId": "1",
        "costOfAssest": 25000.0,
        "deposit": 5000.0,
        "yearlyRateOfInterest": 7.5,
        "noOfMonthlyPayments": 12.0,
        "balloonPaymentAmount": 0.0,
        "totalInterestDue": 821.79,
        "totalPaymentsDue": 12.0,
        "installments": [
        {
            "id": "13",
            "period": 1,
            "payment": 1735.15,
            "prinipal": 1610.15,
            "interest": 125.0,
            "balance": 18389.85,
            "paymentDone": false
        },
        {
            "id": "14",
            "period": 2,
            "payment": 1735.15,
            "prinipal": 1620.21,
            "interest": 114.94,
            "balance": 16769.64,
            "paymentDone": false
        },
        {
            "id": "15",
            "period": 3,
            "payment": 1735.15,
            "prinipal": 1630.34,
            "interest": 104.81,
            "balance": 15139.3,
            "paymentDone": false
        },
        {
            "id": "16",
            "period": 4,
            "payment": 1735.15,
            "prinipal": 1640.53,
            "interest": 94.62,
            "balance": 13498.77,
            "paymentDone": false
        },
        {
            "id": "17",
            "period": 5,
            "payment": 1735.15,
            "prinipal": 1650.78,
            "interest": 84.37,
            "balance": 11847.99,
            "paymentDone": false
        },
        {
            "id": "18",
            "period": 6,
            "payment": 1735.15,
            "prinipal": 1661.1,
            "interest": 74.05,
            "balance": 10186.89,
            "paymentDone": false
        },
        {
            "id": "19",
            "period": 7,
            "payment": 1735.15,
            "prinipal": 1671.48,
            "interest": 63.67,
            "balance": 8515.41,
            "paymentDone": false
        },
        {
            "id": "20",
            "period": 8,
            "payment": 1735.15,
            "prinipal": 1681.93,
            "interest": 53.22,
            "balance": 6833.48,
            "paymentDone": false
        },
        {
            "id": "21",
            "period": 9,
            "payment": 1735.15,
            "prinipal": 1692.44,
            "interest": 42.71,
            "balance": 5141.04,
            "paymentDone": false
        },
        {
            "id": "22",
            "period": 10,
            "payment": 1735.15,
            "prinipal": 1703.02,
            "interest": 32.13,
            "balance": 3438.02,
            "paymentDone": false
        },
        {
            "id": "23",
            "period": 11,
            "payment": 1735.15,
            "prinipal": 1713.66,
            "interest": 21.49,
            "balance": 1724.36,
            "paymentDone": false
        },
        {
            "id": "24",
            "period": 12,
            "payment": 1735.14,
            "prinipal": 1724.37,
            "interest": 10.78,
            "balance": 0.0,
            "paymentDone": false
        }
    ],
    "balloonPayment": false
    }

  d. To Make a payment for a schedule
      
   API Endpoint : localhost:8082/markPaymentDone?loanId=1
      
   Method : PATCH
  
  
