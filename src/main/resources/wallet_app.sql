CREATE TABLE `wallet` 
(
	`id` int,
	`walletId` int,
	`walletName` nvarchar,
	`balance` int
);

CREATE TABLE `transaction` 
(
	`transactionId` int,
	`walletId` int,
	`transactionName` nvarchar,
	`transactionDate` datetime,
	`price` int
);

CREATE TABLE `creditCard` 
(
	`walletId` int,
	`ccId` int,
	`ccNo` int,
	`created_at` datetime,
	`expired_date` datetime,
	`ccv` int,
	`name` nvarchar,
	`updated_at` datetime
);

ALTER TABLE `transaction` ADD FOREIGN KEY (`walletId`) REFERENCES `wallet` (`walletId`);

ALTER TABLE `creditCard` ADD FOREIGN KEY (`walletId`) REFERENCES `wallet` (`walletId`);
