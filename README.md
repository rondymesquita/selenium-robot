# ROBOT
Layer over selenium with multiples drives running in same interface.

## Requirements
- Maven3+
- **JAVA_HOME** on path (tested with java8)

## Configuring
### Dependencies
```bash
mvn eclipse:eclipse
```

###Running
####On Firefox
```bash
mvn test -Pfirefox
```

If no profile is informed, firefox is defined by default.

####Another Maven Profiles
```bash
-Pappium
-Pselendroid
```