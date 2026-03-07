INSERT INTO users (name) VALUES
	('Alice'),
	('Bob'),
	('Charlie');


INSERT INTO bugs (Ttitle, description, status, priority, assigned_to, created_at) VALUES
	('Login bug', 'Users cannot log in with special characters in password', 'Closed', 'High', 1, '2025-12-21 16:27:00'),
	('Login with false info', 'Error message not clear when wrong credentials', 'Open', 'Medium', 3, '2025-12-27 16:41:00'),
	('Payment timeout', 'Payment process times out after 30 seconds', 'In_Progress', 'Critical', 2, '2026-01-15 09:30:00'),
	('UI misalignment', 'Button overlaps with text on mobile view', 'Open', 'Low', 1, '2026-02-03 14:20:00');