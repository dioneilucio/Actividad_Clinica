# Actividad_Clinica

Programa en Java para agendar citas medicas.
El programa te muestra un menu donde te menciona las distintas opciones que desea el usuario realizar.
Permite poder dar de alta a los Doctores de las clinicas junto con su especialidad, a los pacientes, dar de alta la fecha y hora de la cita agendar.
Cada una de la informacion se almacena en un documento txt donde podra tener control de la informacion solicitada y guardada.


Metodos

Metodo para poder iniciar el programa con un usuario y contraseña de administrador
Usuario admin
contraseña admin

public List<String> Login() throws IOException {
        List<String> usuario = new ArrayList<>();
        System.out.println("Login");
        System.out.println("------------------------------");
        System.out.println("Ingrese su id: ");
        usuario.add(reader.readLine());
        System.out.println("Ingrese su contraseña: ");
        usuario.add(reader.readLine());
        return usuario;
  
  Metodo que muetra el menu de las opciones que desea el usuario realizar
  
  public void Menu(){
        System.out.println("Administracion de citas");
        System.out.println("------------------------------");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Dar de alta doctor");
        System.out.println("2. Dar de alta paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Ver citas");
        System.out.println("5. SALIR");
        
        Licencia

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
