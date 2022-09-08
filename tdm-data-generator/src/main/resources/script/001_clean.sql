DELETE FROM orderdetails
DELETE FROM orders
DELETE FROM payments

DELETE FROM products
DELETE FROM productlines

DELETE FROM customers
UPDATE employees SET reportsTo = NULL
DELETE FROM employees
DELETE FROM offices



