# TodoList

## Beskrivning
TodoList är en enkel applikation som låter användare hantera sina att-göra-uppgifter. Användaren kan lägga till, visa, uppdatera och ta bort uppgifter. Applikationen sparar data till en fil för att bevara information mellan sessioner.

## Funktioner
- Lägg till nya uppgifter med beskrivningar.
- Visa alla uppgifter i listan.
- Uppdatera befintliga uppgifter.
- Ta bort uppgifter som inte längre är nödvändiga.
- Spara och ladda uppgifter från en fil.

## Systemkrav
- **Java**: Version 11 eller senare.
- **Maven**: Installerat och konfigurerat.
- **Jenkins**: För kontinuerlig integration (valfritt).

## Så här kör du projektet

### Koden
Koden finns i vårt **publika GitHub-repository**:  
[Länk till repot](https://github.com/andreljungsvik/TodoList)


### Bygga applikationen med Jenkins

#### **Förutsättningar:**
- **Java 11+**, **Jenkins**, och **Maven** installerade.

#### **Steg för att bygga:**
1. Skapa ett nytt Jenkins-jobb:
   - Välj **New Item** och välj **Pipeline**.
2. Klistra in pipeline-skriptet:

```groovy
node {
    stage('Checkout') {
        git branch: 'main', url: 'https://github.com/andreljungsvik/TodoList'
    }
    stage('Build') {
        bat 'mvn clean package javadoc:javadoc'
    }
    stage('Archive') {
        archiveArtifacts artifacts: 'target\\*.jar, target\\site\\apidocs\\**'
    }
    stage('Send Email') {
        emailext body: 'Build completed successfully.',
                 subject: 'Build Result',
                 to: 'testmail@test.com'
    }
}
```

3. Kör pipeline-jobbet med **Build Now**.
   - Bygget sker automatiskt, genererar Javadoc och skickar ett mail med resultatet.


### Köra applikationen

#### **Steg för att köra:**
1. **Ladda ner JAR-filen från Jenkins:**
   - Klicka på den slutförda builden.
   - Navigera till **Build Artifacts**.
   - Ladda ner alla filer som en `.zip`-fil.

2. **Extrahera `.zip`-filen.**

3. **Kör JAR-filen:**
   I terminalen eller kommandotolken:
   java -jar [filnamn].jar
