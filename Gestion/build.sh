chemin_webapps="/home/fabien/Documents/apache-tomcat-9.0.76/webapps"
chemin_bin="/home/fabien/Documents/apache-tomcat-9.0.76/bin"
framework_dir="/home/fabien/Documents/S4/Gestion/"
package_name="objet"
applications_dir="Gestion"
test_class_path="/home/fabien/Documents/S4/Gestion/Gestion/WEB-INF/classes"

echo "Compilation"

cd $test_class_path
ls ../lib
javac -cp "../lib/*" -d . *java

cd $framework_dir

echo "Création du répertoire temporaire"
mkdir temp

cd temp

mkdir User_Guide
mkdir WEB-INF
mkdir assets
mkdir Pages

cd WEB-INF
mkdir classes
cd classes 
mkdir $package_name
cd ..
mkdir lib
cd ../..    


echo "Copie des fichiers jsp"

cp -r $applications_dir/User_Guide/* temp/User_Guide

cp -r $applications_dir/Pages/* temp/Pages

cp -r $applications_dir/assets/ temp/
cp $applications_dir/*.jsp temp/
echo "Copie des fichiers de configuraiton"
cp $applications_dir/WEB-INF/web.xml temp/WEB-INF/
echo "Copie de la librairie"
cp $applications_dir/WEB-INF/lib/* temp/WEB-INF/lib/
echo "Copie des classes"

cp $applications_dir/WEB-INF/classes/$package_name/*.class temp/WEB-INF/classes/$package_name/
rm test/WEB-INF/classes/*.java

cd temp
jar -cvf Gestion.war .
echo "Suppression du répertoire temporaire"
mv Gestion.war $chemin_webapps
cd ..

rm -r temp
cd $chemin_bin

echo "Tomcat RELOADING ...................."

./shutdown.sh
./startup.sh

cd $framework_dir