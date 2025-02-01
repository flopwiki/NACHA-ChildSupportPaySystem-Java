# Security Policy

## Supported Versions
We maintain security updates for the following versions of the Child Support Payment System project:

| Version | Supported          |
| ------- | ------------------ |
| 1.0.24   | :white_check_mark:  |
| < 1.0.21   | :x:                |

## Reporting a Vulnerability

If you discover a security vulnerability, please follow these steps:

- **Email:** Send a detailed report of the vulnerability to [security](mailto:security@nacha.org).
- **Details:** Provide a detailed description of the vulnerability, including how it can be reproduced.
- **Response:** We will respond to your report within 48 hours to work with you and resolve the issue as quickly as possible.

Please do not disclose the vulnerability publicly until we have fixed it and released a patch.

## Security Process

- Regular vulnerability scans and code reviews.
- Use of security tools (see Tools section below).
- Third-party audits on major releases.

## Tools

We use the following tools to monitor and address security issues:
- **Dependency-Check:** Regular scans of project dependencies for vulnerabilities.
- **SonarQube:** Static code analysis to ensure code quality and security.
- **Gradle security plugins:** Check for outdated dependencies.
