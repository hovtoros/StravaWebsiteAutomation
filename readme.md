# Strava Website Automation
A project to automate some crucial patterns of user behavior on Strava.com.

### Tools, languages and frameworks consumed:
- Java, Maven, TestNG
- Selenium WebDriver
- Docker Hub

### Tests implemented using POM design pattern:
- SuccessfulLoginTest
- UnsuccessfulLoginInvalidEmailTest
- UnsuccessfulLoginInvalidPasswordTest
- UserProfileInformationTest
- AddManualTrainingSuccessfullyUserDashboardTest

## Getting started
1. Download and unzip the project into a desired directory.
2. Download and install [Docker](https://docs.docker.com/desktop/) on your machine.
3. Open the CMD terminal from project root directory, run the following command:

```shell script
docker-compose up -d
```

Now check this link to be working: http://localhost:4444/grid/console

If yes, then you can start running the project.