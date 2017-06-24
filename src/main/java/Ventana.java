/**
 * Created by YepezHinostroza on 23/6/2017.
 */

//import com.intellij.ui.components.JBOptionButton;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame implements ActionListener {
    Container contenedor=getContentPane();
    Controlador controlador;
    BibliotecaModel modelo;


    public static void main(String[] args) {
        BibliotecaModel modelo = BibliotecaModel.getUniqueInstance();
        Controlador control = new ControladorBibliotecario();
        Ventana ventana = new Ventana( control,  modelo);


    }

    public Ventana(Controlador controlador, BibliotecaModel modelo ) {


        super("Biblioteca");
        this.modelo =modelo;
        this.controlador = controlador;
        //this.logIn();
        //this.agregarAfiliado();
        this.menuInicial();
        setVisible(true);


    }

    public void setPermisos(Controlador permiso) {
        this.controlador = permiso;
    }

    public void menuInicial() {

        setPermisos(modelo.getControlador());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor.removeAll();
        setSize(300, 200);
        GridLayout gl = new GridLayout(4, 1);
        gl.setHgap(5);
        gl.setVgap(15);
        contenedor.setLayout(gl);
        JLabel acceso;
        JButton login;
        login = new JButton("Log in");
        acceso= new JLabel("Menu Inicial",SwingConstants.CENTER);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.removeActionListener(this);
                logIn();
            }
        });

        JButton consulta = new JButton("Consulta");
        JLabel fecha = new JLabel((new Date()).toString());
        contenedor.add(acceso);
        contenedor.add(consulta);
        contenedor.add(login);
        contenedor.add(fecha);
        contenedor.validate();
        contenedor.repaint();
    }
    public void menuBibliotecario() {

        setPermisos(modelo.getControlador());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor.removeAll();
        setSize(300, 400);
        GridLayout gl = new GridLayout(8, 1);
        gl.setHgap(5);
        gl.setVgap(15);
        contenedor.setLayout(gl);
        JLabel acceso;
        JButton login;
        JButton logout;
        logout = new JButton("Log out");

            acceso = new JLabel(("Biliotecario"));


        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                logout();
            }
        });
        JButton consulta = new JButton("Consulta");

        JButton afiliado = new JButton("Afiliados");
        afiliado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });
        JLabel fecha = new JLabel((new Date()).toString());
        JButton prestamo = new JButton("Prestamo");
        JButton ejemplar = new JButton("Ejemplares");
        JButton modFecha = new JButton("Fecha");
        contenedor.add(acceso);
        contenedor.add(prestamo);
        contenedor.add(consulta);
        contenedor.add(afiliado);
        contenedor.add(ejemplar);

        contenedor.add(modFecha);
        contenedor.add(logout);
        contenedor.add(fecha);
        contenedor.validate();
        contenedor.repaint();
    }
    public void logout(){
        contenedor.removeAll();
        this.setSize(200,200);
        JLabel fin = new JLabel("Ha finalizado Sesion",SwingConstants.CENTER);

        JButton aceptar = new JButton("Aceptar");
        GridLayout gl = new GridLayout(2, 1, 0, 30);
        contenedor.setLayout(gl);
        contenedor.add(fin);
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.logout(modelo);

                menuInicial();
            }
        });
        contenedor.validate();
        contenedor.repaint();



    }
    public void logIn(){
        contenedor.removeAll();
        this.setSize(400,300);
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(2, 2, 0, 30);
        panelDatos.setLayout(gl);
        panelDatos.add(new JLabel("ID:"));
        JTextField id= new JTextField(16);
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panelDatos.add(id);
        panelDatos.add(new JLabel("Password:"));
        JPasswordField password= new JPasswordField(16);
        panelDatos.add(password);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        JButton aceptar=new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.login(Integer.parseInt(id.getText()),password.getText(),modelo))
                menuBibliotecario();
                else{
                    menuInicial();
                }
            }
        });
        panelBotones.add(aceptar);
        JButton cancelar=new JButton("Cancelar");
        panelBotones.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuInicial();
            }
        });
        //Container cp = getContentPane();
        contenedor.setLayout(new GridLayout(2,1,20,50));
        contenedor.add(panelDatos);
        contenedor.add(panelBotones);
        contenedor.validate();
        contenedor.repaint();

    }
    public void Afiliados(){
        contenedor.removeAll();
        setSize(300, 400);
        GridLayout gl= new GridLayout(8,1,10,10);
        JLabel etiqueta = new JLabel("Operaciones sobre Afiliados",SwingConstants.CENTER);


        JButton agregar = new JButton("Agregar");
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAfiliado();
            }
        });

        JButton borrar = new JButton("Borrar ");
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarAfiliado();
            }
        });

        JButton suspender = new JButton("Suspender");
        suspender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               suspender();
            }
        });

        JButton modDatos = new JButton("Modificar datos");
        modDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modDatos();
            }
        });


        JButton verRegistro = new JButton("Ver Registro");
        verRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verAfiliados();
            }
        });

        JButton atras = new JButton("Volver al menu");
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBibliotecario();
            }
        });
        contenedor.setLayout(gl);
        contenedor.add(etiqueta);
        contenedor.add(agregar);
        contenedor.add(borrar);
        contenedor.add(suspender);
        contenedor.add(modDatos);
        contenedor.add(verRegistro);
        contenedor.add(atras);

        contenedor.validate();
        contenedor.repaint();


    }
    public void agregarAfiliado() {
        /*JPanel panelFecha = new JPanel();
        panelFecha.setLayout(new FlowLayout());
        panelFecha.add(new JTextField(2));
        panelFecha.add(new JLabel("/"));
        panelFecha.add(new JTextField(2));
        panelFecha.add(new JLabel("/"));
        panelFecha.add(new JTextField(2));
        */
        // Panel de datos
        setSize(300,400);
        contenedor.removeAll();
        GridLayout gl = new GridLayout(7,2,30,30);

        contenedor.setLayout(gl);
        contenedor.add(new JLabel("Agregar nuevo afiliado:"));
        contenedor.add(new JLabel(""));
        JLabel dni = new JLabel("DNI: ");
        contenedor.add(dni);
        JTextField Tdni = new JTextField(16);
        contenedor.add(Tdni);
        Tdni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Nombre:"));
        JTextField Tnombre = new JTextField(16);
        contenedor.add(Tnombre);
        Tnombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Apellido:"));
        JTextField Tapellido = new JTextField(16);
        contenedor.add(Tapellido);
        Tapellido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Telefono:"));
        JTextField Ttelefono= new JTextField(16);
        contenedor.add(Ttelefono);
        Ttelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Direccion:"));
        JTextField Tdirec = new JTextField(16);
        contenedor.add(Tdirec);
        Tdirec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Panel de botones


        JButton aceptar=  new JButton("Aceptar");
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.afiliar(Integer.parseInt(Tdni.getText()),Tnombre.getText(),Tapellido.getText(),Ttelefono.getText(),Tdirec.getText(),modelo);
                Afiliados();
            }
        });

        JButton cancelar=  new JButton("Cancelar");
        contenedor.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });



        contenedor.validate();
        contenedor.repaint();

    }
    public void verAfiliados(){
        contenedor.removeAll();
        setSize(700,300);
        contenedor.setLayout(new GridLayout(2,1));
        JList<Afiliado> lista = new JList<Afiliado>();
        JButton volver = new JButton("Volver");
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel listModel = new DefaultListModel();
        for(Afiliado afi: controlador.verAfiliados(modelo)){
            if(afi.getFechaSuspension()!=null)
            listModel.addElement("" +afi.getId()+"  "+afi.getNombre()+"  "+afi.getApellido()+ "   Suspendido hasta: "+ afi.getFechaSuspension().getDate()+"/"+(afi.getFechaSuspension().getMonth()+1));
            else{
                listModel.addElement("" +afi.getId()+"  "+afi.getNombre()+"  "+afi.getApellido());
            }

        }
        lista.setModel(listModel);

        JScrollPane scrollLista;
        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 120,220, 80);
        volver.setSize(100,100);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });
        contenedor.add(lista);
        contenedor.add(volver);
        contenedor.validate();
        contenedor.repaint();
    }
    public void borrarAfiliado(){
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(1,2,15,15));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,30,30));
        superior.add(new JLabel("Ingrese el DNI del usuario a borrar"));
        //superior.add(new JLabel(""));
        central.add(new JLabel("DNI :"));
        JTextField dni = new JTextField(16);
        dni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(dni);
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.desafiliar(Integer.parseInt(dni.getText()), modelo))
                    Afiliados();

            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Afiliados();

            }
        });
        inferior.add(aceptar);
        inferior.add(cancelar);
        contenedor.add(superior);
        contenedor.add(central);
        contenedor.add(inferior);
        contenedor.validate();
        contenedor.repaint();

;

    }
    public void suspender(){
        contenedor.removeAll();
        contenedor.setLayout(new GridLayout(3,1));
        JLabel superior = new JLabel("Borrar Afiliado del registro");
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(3,2,10,10));
        central.add(new JLabel("ID:"));
        JTextField id = new JTextField(16);
        central.add(id);
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(new JLabel("Dia:"));
        JTextField dia = new JTextField(16);
        central.add(dia);
        dia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(new JLabel("Mes: "));
        JTextField mes = new JTextField(16);
        central.add(mes);
        mes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.suspender(Integer.parseInt(id.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText()), modelo))
                    Afiliados();
            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });
        inferior.add(aceptar);
        inferior.add(cancelar);
        contenedor.add(superior);
        contenedor.add(central);
        contenedor.add(inferior);
        contenedor.validate();
        contenedor.repaint();


    }
    public void modDatos(){
        contenedor.removeAll();
        setSize(300,500);
        contenedor.setLayout(new GridLayout(5,1,30,30));
        JPanel panel1= new JPanel();
        panel1.add(new JLabel("Modificar datos de un Afiliado existende: "));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2,20,20));
        panel2.add(new JLabel("DNI: "));

        JTextField dni = new JTextField(16);
        panel2.add(dni);
        dni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,2,20,20));
        panel3.add(new JLabel("Nuevo telefono: "));
        JTextField telefono = new JTextField(16);
        panel3.add(telefono);
        telefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2,20,20));
        panel4.add(new JLabel("Nueva Direccion: "));
        JTextField direccion = new JTextField(16);

        panel4.add(direccion);
        direccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        JButton aceptar =  new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.modDatos(Integer.parseInt(dni.getText()),telefono.getText(),direccion.getText(),modelo))
                    Afiliados();
            }
        });
        panel5.add(aceptar);
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });
        panel5.add(cancelar);
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        contenedor.add(panel4);
        contenedor.add(panel5);
        contenedor.validate();
        contenedor.repaint();

    }
    public void actionPerformed(ActionEvent event) {
        /*if (event.getSource() == setBPMButton) {
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBPM(bpm);
        } else if (event.getSource() == increaseBPMButton) {
            controller.increaseBPM();
        } else if (event.getSource() == decreaseBPMButton) {
            controller.decreaseBPM();
        }*/
    }


}
