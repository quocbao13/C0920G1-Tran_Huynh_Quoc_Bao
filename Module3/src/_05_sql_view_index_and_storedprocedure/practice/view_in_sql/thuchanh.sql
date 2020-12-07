-- tạo view
CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;

-- Kết quả, ta sẽ có 1 bảng ảo customer_views, và sau đó chúng ta hoàn toàn có thể lấy dữ liệu từ bảng ảo này bằng lệnh:

select * from customer_views;

-- sửa view
CREATE OR REPLACE VIEW view_name AS

SELECT customerNumber, customerName

FROM customers;

CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';

-- xóa view

DROP VIEW view_name;

DROP VIEW customer_views;