CREATE TABLE audittrail(
  id BIGINT NOT NULL AUTO_INCREMENT,
  sales_id BIGINT NOT NULL,
  account_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (sales_id) REFERENCES sale(id),
  FOREIGN KEY (account_id) REFERENCES account(id)
);