\# Bug Tracking \& Analysis System





\## Project Description



This project is a bug tracking system designed to store, manage, and analyze software bugs for developers.

It demonstrates database design, SQL analytics, and business insights for software quality management.



\*\*Purpose:\*\*



\- Track bug status, priority, and assignments

\- Analyze workload distribution

\- Identify aging bugs and backlog risks

\- Showcase SQL and data analytics skills



\## Tech Stack



\- Java (Eclipse IDE)

\- PostgreSQL

\- SQL

\- Optional Visualization: Power BI / Tableau





\## Database Schema



\### users table



| Column   | Type    | Description      |

|----------|---------|------------------|

| user\_id  | integer | Primary key      |

| name     | varchar | Developer name   |



\### bugs table



| Column            | Type            | Description                                              |

|-------------------|-----------------|----------------------------------------------------------|

| bug\_id            | integer         | Primary key                                              |

| title             | varchar         | Short bug title                                          |

| description       | text            | Detailed bug description                                 |

| status            | varchar         | Bug status ('Open', 'In progress', 'Resolved', 'Closed')  |

| priority          | varchar         | Bug priority ('Low', 'Medium', 'High', 'Critical')       |

| assigned\_to       | integer         | FK → users.user\_id                                       |

| created\_at        | timestamp       | Bug creation timestamp                                   |





\*\*Relationships:\*\*

* 'bugs.assigned\_to' → 'users.user\_id' (one bug is assigned to one developer)



\## Sample Data



\### Users



| user\_id    | name         |

|------------|--------------|

| 1          | Alice        |

| 2          | Bob          |

| 3          | Charlie      |





\### Bugs



| bug\_id  | title                 | status          | priority       | assigned\_to  | created\_at                  |

|---------|-----------------------|-----------------|----------------|--------------|-----------------------------|

| 1       | Login bug             | Closed          | High           | 1            | 2025-12-21 16:27            |

| 2       | Login with false infos| Open            | Medium         | 3            | 2025-12-27 16:41            |





\## SQL Analysis Queries



1\. \*\*Bugs by Status\*\*

```sql

SELECT status, COUNT(\*) AS bug\_count

FROM public.bugs

GROUP BY status;

```



2\. \*\*Bugs by Priority\*\*

```sql

SELECT priority, COUNT(\*) AS bug\_count

FROM public.bugs

GROUP BY priority;

```



3\. \*\*Developer Workload\*\*

```sql

SELECT u.name AS developer, COUNT(b.bug\_id) AS assigned\_bugs

FROM public.users u

LEFT JOIN public.bugs b ON u.user\_id = b.assigned\_to

GROUP BY u.name

ORDER BY assigned\_bugs DESC;

```



4\. \*\*Aging/Open Bugs\*\*

```sql

SELECT bug\_id, title, status, priority, created\_at, 

&nbsp;      CURRENT\_DATE - created\_at::date AS days\_open

FROM public.bugs

WHERE status IN ('Open', 'In progress')

ORDER BY days\_open DESC;

```



5\. \*\*Monthly Bug Trend\*\*

```sql

SELECT DATE\_TRUNC('month', created\_at) AS month, COUNT(\*) AS bug\_count

FROM public.bugs

GROUP BY month

ORDER BY month;

```



6\. \*\*Unassigned Bugs\*\*

```sql

SELECT bug\_id, title, status, priority

FROM public.bugs

WHERE assigned\_to IS NULL;

```



