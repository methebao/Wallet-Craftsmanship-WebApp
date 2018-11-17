CREATE TABLE `account` 
(
	`id` int,
	`username` varchar(255),
	`password` nvarchar,
	`firstname` nvarchar,
	`lastname` nvarchar,
	`status` varchar(255),
	`created_at` datetime
);

CREATE TABLE `accountBalance` 
(
	`id` int,
	`walletId` int,
	`numbOfWallet` int,
	`TotalBalance` int
);

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

CREATE TABLE `walletCard` 
(
	`walletId` int,
	`ccId` int
);

CREATE TABLE `creditCard` 
(
	`ccId` int,
	`ccNo` int,
	`created_at` datetime,
	`expired_date` datetime,
	`ccv` int,
	`name` nvarchar,
	`updated_at` datetime
);

ALTER TABLE `wallet` ADD FOREIGN KEY (`id`) REFERENCES `account` (`id`);

ALTER TABLE `accountBalance` ADD FOREIGN KEY (`id`) REFERENCES `account` (`id`);

ALTER TABLE `accountBalance` ADD FOREIGN KEY (`walletId`) REFERENCES `wallet` (`walletId`);

ALTER TABLE `transaction` ADD FOREIGN KEY (`walletId`) REFERENCES `wallet` (`walletId`);

ALTER TABLE `walletCard` ADD FOREIGN KEY (`ccId`) REFERENCES `creditCard` (`ccId`);

ALTER TABLE `wallet` ADD FOREIGN KEY (`walletId`) REFERENCES `walletCard` (`walletId`);
