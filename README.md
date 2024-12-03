# JUnit Advanced

## Introduction

This repository contains the code for the JUnit Advanced kata. 
The kata is designed to help you understand the advanced features of JUnit and how to use them effectively.

## Getting Started

To get started, clone this repository to your local machine and open it in your favourite IDE.

## Running the Tests

```bash
$ mvn test
```

## Kata

These annotations are used :

- `@DisplayName` : This annotation is used to provide a custom name for the test class or test method.
- `@Nested` : This annotation is used to create a nested test class.
- `@ParameterizedTest` : This annotation is used to run the test multiple times with different arguments.
- `@CsvSource` : This annotation is used to provide the arguments for the parameterized test.
- `@CsvFileSource` : This annotation is used to provide the arguments for the parameterized test from a CSV file.

This Kata will be completed with the following annotations in a near future :

- `@ValueSource` : This annotation is used to provide the arguments for the parameterized test.
- `@MethodSource` : This annotation is used to provide the arguments for the parameterized test from a method.
- `@RepeatedTest` : This annotation is used to run the test multiple times.
- `@TestFactory` : This annotation is used to create a dynamic test.
- `@TestTemplate` : This annotation is used to create a template for a test.
- `@ExtendWith` : This annotation is used to extend the behavior of the test class.
- `@RegisterExtension` : This annotation is used to register an extension for the test class.
- `@Tag` : This annotation is used to tag the test class or test method.

As well as difference between **Assertions** and **Assumptions.**