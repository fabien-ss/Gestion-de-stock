class_path="/home/fabien/Desktop/Frame/Framework/Framework/build/web/WEB-INF/classes"
librairies_path="/home/fabien/Documents/S4/Gestion/Gestion/WEB-INF/lib"

cd $class_path
jar -cf etu2004Files.jar .
mv etu2004Files.jar $librairies_path
