# The Ledger Co. Loan Management System

## Overview

The Ledger Co. Loan Management System is a Java application designed to manage loans provided by banks to borrowers. It
allows users to record loans, track payments, and retrieve the current balance and remaining EMIs for each borrower.

## Features

- Record loans with details such as bank name, borrower name, principal amount, loan period, and interest rate.
- Accept lump sum payments from borrowers during the loan period.
- Calculate the total amount paid by the borrower and the remaining EMIs at any point in time.
- Handle scenarios such as partial payments and early repayments.

## Installation

To run the application, you need:

- Java Development Kit (JDK) installed on your system.
- Apache Maven build tool installed on your system.

## Usage

1. Clone the repository to your local machine:

git clone https://github.com/naveenerroju/theledgerco

2. Navigate to the project directory:

cd theledgerco

3. Build the project using Maven:

maven clean install

4. Run the application:

java -jar target/theledgerco.jar

5. Follow the prompts to enter loan details, record payments, and retrieve borrower balances.

## Input Commands

The application supports three input commands:

1. **LOAN**: Record a new loan.
   LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST

2. **PAYMENT**: Record a lump sum payment from the borrower.
   PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO


3. **BALANCE**: Retrieve the total amount paid and remaining EMIs for a borrower.
   BALANCE BANK_NAME BORROWER_NAME EMI_NO

## Example Usage

To record a loan:

LOAN IDIDI Dale 10000 5 4

To record a payment:

PAYMENT MBI Dale 1000 5

To retrieve the balance:

BALANCE MBI Harry 12

## Assumptions

1. Repayments are made monthly as EMIs until the total amount is recovered.
2. Lump sum payments can be made at any point before the end of the loan tenure.
3. EMI amounts are rounded up to the nearest integer.
4. The number of EMIs is rounded up to the nearest whole number.
5. The last EMI is adjusted to match the remaining amount to pay.
6. Lump sum payments are included in the total amount remaining at any EMI number.
7. Borrowers can avail only one loan at a time.
