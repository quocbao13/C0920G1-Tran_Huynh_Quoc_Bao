-- select thông thường
SELECT * FROM customers WHERE customerNumber = 175; 

-- select tăng tốc
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;

-- select chỉ mục
ALTER TABLE customers ADD INDEX idx_customerNumber(customerNumber);
EXPLAIN SELECT * FROM customers WHERE customerNumber = 175;