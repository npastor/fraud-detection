
-- Add Current Month Data

INSERT INTO `current_month_data` (`id`, `monthly_amount_spent`,`monthly_frequency`) VALUES (1, 1000, 4);
INSERT INTO `current_month_data` (`id`, `monthly_amount_spent`,`monthly_frequency`) VALUES (2, 2000, 4);
INSERT INTO `current_month_data` (`id`, `monthly_amount_spent`,`monthly_frequency`) VALUES (3, 3000, 20);
INSERT INTO `current_month_data` (`id`, `monthly_amount_spent`,`monthly_frequency`) VALUES (4, 4000, 4);


-- Add Monthly Aggregated Data

INSERT INTO `monthly_aggregated_data` (`id`, `avg_monthly_frequency`,`avg_monthly_spent_amount`) VALUES (1, 40, 2000);
INSERT INTO `monthly_aggregated_data` (`id`, `avg_monthly_frequency`,`avg_monthly_spent_amount`) VALUES (2, 30, 4000);
INSERT INTO `monthly_aggregated_data` (`id`, `avg_monthly_frequency`,`avg_monthly_spent_amount`) VALUES (3, 20, 4330);
INSERT INTO `monthly_aggregated_data` (`id`, `avg_monthly_frequency`,`avg_monthly_spent_amount`) VALUES (4, 40, 4111);


-- Add Customer Data

INSERT INTO `customer` (`customer_id`, `monthly_aggregated_data_id`, `current_month_data_id`, `billing_name`, `daily_spend_limit`, `daily_allowed_frequency`) VALUES (1,1,1,'Customer1', 200, 5);
INSERT INTO `customer` (`customer_id`, `monthly_aggregated_data_id`, `current_month_data_id`, `billing_name`, `daily_spend_limit`, `daily_allowed_frequency`) VALUES (2,2,2,'Customer2', 200, 10);
INSERT INTO `customer` (`customer_id`, `monthly_aggregated_data_id`, `current_month_data_id`, `billing_name`, `daily_spend_limit`, `daily_allowed_frequency`) VALUES (3,3,3,'Customer3', 300, 10);
INSERT INTO `customer` (`customer_id`, `monthly_aggregated_data_id`, `current_month_data_id`, `billing_name`, `daily_spend_limit`, `daily_allowed_frequency`) VALUES (4,4,4,'Customer4', 400, 5);





