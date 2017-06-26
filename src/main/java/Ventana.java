/**
 * Created by YepezHinostroza on 23/6/2017.
 */

//import com.intellij.ui.components.JBOptionButton;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame implements ActionListener,  Observer {
    Container contenedor= this.getContentPane();
    Controlador controlador;
    BibliotecaModel modelo;
    private static JLabel fechaModelo;
    private EstadoVentanas actual;



    public Ventana( BibliotecaModel modelo ) {


        super("Biblioteca");

        this.modelo =modelo;
        this.controlador = new ControladorAfiliado();
        fechaModelo = new JLabel(""+controlador.getFecha(modelo).getDate()+"/"+(controlador.getFecha(modelo).getMonth()+1)+"/"+((controlador.getFecha(modelo).getYear())+1900));

        this.menuInicial();
        setVisible(true);
        modelo.registerObserver(this);






    }

    public void update(){
        fechaModelo = new JLabel(""+controlador.getFecha(modelo).getDate()+"/"+(controlador.getFecha(modelo).getMonth()+1)+"/"+((controlador.getFecha(modelo).getYear()+1900)));
        actualizarVentana();


    }

    public void menuInicial() {
        this.actual = EstadoVentanas.INICIAL;
        //setPermisos(modelo.getControlador());
        this.controlador =new ControladorAfiliado();
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
                //login.removeActionListener(this);
                logIn();
            }
        });

        JButton consulta = new JButton("Consulta");
        //////////////////////////////////////////////////////////////////////////////
        //fechaModelo = new JLabel(modelo.getDate().toString());
        contenedor.add(acceso);
        contenedor.add(consulta);
        contenedor.add(login);
        contenedor.add(fechaModelo);
        contenedor.validate();
        contenedor.repaint();
    }
    public void menuBibliotecario() {
        this.actual = EstadoVentanas.BIBLIOTECARIO;
        this.controlador =new ControladorBibliotecario();
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
        JButton consulta = new JButton("Consultas");

        JButton afiliado = new JButton("Afiliados");
        afiliado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Afiliados();
            }
        });
        /////////////////////////////////////////////////////////////////////////////////
        //fechaModelo = new JLabel(modelo.getDate().toString());
        JButton prestamo = new JButton("Prestamos");
        prestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestamos();
            }
        });
        JButton ejemplar = new JButton("Ejemplares");
        ejemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejemplares();
            }
        });
        JButton modFecha = new JButton("Fecha");
        modFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modFecha();
            }
        });
        contenedor.add(acceso);
        contenedor.add(prestamo);
        contenedor.add(consulta);
        contenedor.add(afiliado);
        contenedor.add(ejemplar);

        contenedor.add(modFecha);
        contenedor.add(logout);
        contenedor.add(fechaModelo);
        contenedor.validate();
        contenedor.repaint();
    }
    public void logout(){
        this.actual = EstadoVentanas.LOGOUT;
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
                //controlador.logout(modelo);

                menuInicial();
            }
        });
        contenedor.validate();
        contenedor.repaint();



    }
    public void logIn(){
        this.actual = EstadoVentanas.LOGIN;
        contenedor.removeAll();
        this.setSize(400,300);
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(new JLabel("Ingrese sus datos: "));
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(2, 2, 20, 20);
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
        contenedor.setLayout(new GridLayout(3,1,20,20));
        contenedor.add(panelSuperior);
        contenedor.add(panelDatos);
        contenedor.add(panelBotones);
        contenedor.validate();
        contenedor.repaint();

    }
    public void Afiliados(){
        this.actual = EstadoVentanas.AFILIADOS;
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
        JButton modPermisos= new JButton("Modificar Permisos");
        modPermisos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modPermisos();
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
        contenedor.add(modPermisos);
        contenedor.add(verRegistro);
        contenedor.add(atras);

        contenedor.validate();
        contenedor.repaint();


    }
    public void agregarAfiliado() {
        this.actual = EstadoVentanas.AGREGARAFILIADO;
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
        this.actual = EstadoVentanas.VERAFILIADOS;
        contenedor.removeAll();
        setSize(700,300);
        contenedor.setLayout(new GridLayout(2,1));
        JList<Afiliado> lista = new JList<Afiliado>();
        JButton volver = new JButton("Volver");
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel listModel = new DefaultListModel();
        for(Afiliado afi: controlador.verAfiliados(modelo)){
            if(afi.getFechaSuspension()!=null&&afi.getFechaSuspension().compareTo(controlador.getFecha(modelo))>0)
            listModel.addElement("" +afi.getId()+"  "+afi.getNombre()+"  "+afi.getApellido()+ "   Suspendido hasta: "+afi.getFechaSuspension().toString()+" "+ afi.getFechaSuspension().getDate()+"/"+(afi.getFechaSuspension().getMonth()+1));
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
        this.actual = EstadoVentanas.BORRARAFILIADO;
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


    }
    public void suspender(){
        this.actual = EstadoVentanas.SUSPENDER;
        contenedor.removeAll();
        contenedor.setLayout(new GridLayout(3,1));
        JLabel superior = new JLabel("Suspender afiliado hasta la fecha fijada ");
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
        this.actual = EstadoVentanas.MODDATOS;
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
    public void modPermisos(){
        this.actual = EstadoVentanas.MODPERMISOS;
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(2,2,0,0));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,20,20));
        superior.add(new JLabel("Ingrese el DNI del nuevo bibliotecario"));
        central.add(new JLabel("DNI :"));
        JTextField dni = new JTextField(16);
        dni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(dni);
        central.add(new JLabel("Contrasena: "));
        JPasswordField contra = new JPasswordField(16);
        contra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(contra);
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.modPermisos(Integer.parseInt(dni.getText()),contra.getText(), modelo))
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


    public void ejemplares(){
        this.actual = EstadoVentanas.EJEMPLARES;
        contenedor.removeAll();
        setSize(300, 400);
        contenedor.setLayout(new GridLayout(6,1,10,10));
        contenedor.add(new JLabel("Acciones sobre Ejemplares"));
        JButton agregar = new JButton("Agregar Ejemplar");
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplares();
            }
        });
        contenedor.add(agregar);
        JButton borrar = new JButton("Borrar Ejemplar");
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarEjemplar();
            }
        });
        contenedor.add(borrar);
        JButton darBaja = new JButton("Dar de baja disponibilidad");
        darBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darBaja();
            }
        });
        contenedor.add(darBaja);
        JButton verEjemplares = new JButton("Ver registro de Ejemplares");
        verEjemplares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verEjemplares();
            }
        });
        contenedor.add(verEjemplares);
        JButton volver = new JButton("Volver");
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBibliotecario();
            }
        });
        contenedor.add(volver);
        contenedor.validate();
        contenedor.repaint();

    }

    public void agregarEjemplares(){
        this.actual = EstadoVentanas.AGREGAREJEMPLARES;
        contenedor.removeAll();
        setSize(300,500);
        contenedor.setLayout(new GridLayout(6,1,15,15));
        contenedor.add(new JLabel("Seleccione el tipo de ejemplar"));
        JButton libro = new JButton("Libro");
        libro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        contenedor.add(libro);
        JButton audio = new JButton("Audiovisual");
        audio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAudioVisual();
            }
        });
        contenedor.add(audio);
        JButton revista = new JButton("Revista");
        revista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarRevista();
            }
        });
        contenedor.add(revista);
        JButton tesis = new JButton("Tesis");
        tesis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTesis();
            }
        });
        contenedor.add(tesis);
        JButton volver = new JButton("Volver");
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejemplares();
            }
        });
        contenedor.add(volver);
        contenedor.validate();
        contenedor.repaint();


    }

    public void agregarLibro(){
        this.actual = EstadoVentanas.AGREGARLIBRO;
        setSize(300,500);
        contenedor.removeAll();
        GridLayout gl = new GridLayout(8,2,15,15);

        contenedor.setLayout(gl);
        contenedor.add(new JLabel("Agregar nuevo Libro:"));
        contenedor.add(new JLabel(""));
        JLabel titulo = new JLabel("Titulo: ");
        contenedor.add(titulo);
        JTextField ttitulo = new JTextField(16);
        contenedor.add(ttitulo);
        ttitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Autor:"));
        JTextField ttautor = new JTextField(16);
        contenedor.add(ttautor);
        ttautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Fecha:"));
        JTextField tfecha = new JTextField(16);
        contenedor.add(tfecha);
        tfecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Categoria: "));
        //String[] categorias = [""]
        JComboBox categoria = new JComboBox(Categoria.values());
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(categoria);
        contenedor.add(new JLabel("Edicion:"));
        JTextField tedicion= new JTextField(16);
        contenedor.add(tedicion);
        tedicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Editorial:"));
        JTextField teditorial = new JTextField(16);
        contenedor.add(teditorial);
        teditorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Panel de botones

        //JPanel inferior = new JPanel();
        //inferior.setLayout(new FlowLayout());
        JButton aceptar=  new JButton("Aceptar");
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.agregarLibro(ttitulo.getText(),ttautor.getText(),tfecha.getText(),(Categoria)categoria.getSelectedItem(),Integer.parseInt(tedicion.getText()),teditorial.getText(),modelo))
                agregarEjemplares();
            }
        });

        JButton cancelar=  new JButton("Cancelar");
        contenedor.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplares();
            }
        });



        contenedor.validate();
        contenedor.repaint();

    }
    public void agregarRevista(){
        this.actual = EstadoVentanas.AGREGARREVISTA;
        setSize(300,500);
        contenedor.removeAll();
        GridLayout gl = new GridLayout(6,2,15,15);

        contenedor.setLayout(gl);
        contenedor.add(new JLabel("Agregar nueva Revista:"));
        contenedor.add(new JLabel(""));
        JLabel titulo = new JLabel("Titulo: ");
        contenedor.add(titulo);
        JTextField ttitulo = new JTextField(16);
        contenedor.add(ttitulo);
        ttitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Autor:"));
        JTextField ttautor = new JTextField(16);
        contenedor.add(ttautor);
        ttautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Fecha:"));
        JTextField tfecha = new JTextField(16);
        contenedor.add(tfecha);
        tfecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Categoria: "));
        //String[] categorias = [""]
        JComboBox categoria = new JComboBox(Categoria.values());
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(categoria);



        JButton aceptar=  new JButton("Aceptar");
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.agregarRevista(ttitulo.getText(),ttautor.getText(),tfecha.getText(),(Categoria)categoria.getSelectedItem(),modelo))
                agregarEjemplares();
            }
        });

        JButton cancelar=  new JButton("Cancelar");
        contenedor.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplares();
            }
        });



        contenedor.validate();
        contenedor.repaint();

    }
    public void agregarAudioVisual(){
        this.actual = EstadoVentanas.AGREGARAUDIOV;
        setSize(300,500);
        contenedor.removeAll();
        GridLayout gl = new GridLayout(9,2,15,15);

        contenedor.setLayout(gl);
        contenedor.add(new JLabel("Agregar nuevo Audiovisual:"));
        contenedor.add(new JLabel(""));
        JLabel titulo = new JLabel("Titulo: ");
        contenedor.add(titulo);
        JTextField ttitulo = new JTextField(16);
        contenedor.add(ttitulo);
        ttitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Autor:"));
        JTextField ttautor = new JTextField(16);
        contenedor.add(ttautor);
        ttautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Fecha:"));
        JTextField tfecha = new JTextField(16);
        contenedor.add(tfecha);
        tfecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Categoria: "));
        //String[] categorias = [""]
        JComboBox categoria = new JComboBox(Categoria.values());
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(categoria);
        contenedor.add(new JLabel("Edicion:"));
        JTextField tedicion= new JTextField(16);
        contenedor.add(tedicion);
        tedicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Editorial:"));
        JTextField teditorial = new JTextField(16);
        contenedor.add(teditorial);
        teditorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Duracion en segundos:"));
        JTextField tduracion = new JTextField(16);
        contenedor.add(tduracion);
        tduracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Panel de botones

        //JPanel inferior = new JPanel();
        //inferior.setLayout(new FlowLayout());
        JButton aceptar=  new JButton("Aceptar");
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.agregarAudoVisual(ttitulo.getText(),ttautor.getText(),tfecha.getText(),(Categoria)categoria.getSelectedItem(),tedicion.getText(),teditorial.getText(),tduracion.getText(),modelo))
                    agregarEjemplares();
            }
        });

        JButton cancelar=  new JButton("Cancelar");
        contenedor.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplares();
            }
        });



        contenedor.validate();
        contenedor.repaint();


    }

    public void agregarTesis(){
        this.actual = EstadoVentanas.AGREGARTESIS;
        setSize(300,500);
        contenedor.removeAll();
        GridLayout gl = new GridLayout(6,2,15,15);

        contenedor.setLayout(gl);
        contenedor.add(new JLabel("Agregar nueva tesis:"));
        contenedor.add(new JLabel(""));
        JLabel titulo = new JLabel("Titulo: ");
        contenedor.add(titulo);
        JTextField ttitulo = new JTextField(16);
        contenedor.add(ttitulo);
        ttitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Autor:"));
        JTextField ttautor = new JTextField(16);
        contenedor.add(ttautor);
        ttautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contenedor.add(new JLabel("Fecha:"));
        JTextField tfecha = new JTextField(16);
        contenedor.add(tfecha);
        tfecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(new JLabel("Categoria: "));
        //String[] categorias = [""]
        JComboBox categoria = new JComboBox(Categoria.values());
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contenedor.add(categoria);



        // Panel de botones

        //JPanel inferior = new JPanel();
        //inferior.setLayout(new FlowLayout());
        JButton aceptar=  new JButton("Aceptar");
        contenedor.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.agregarTesis(ttitulo.getText(),ttautor.getText(),tfecha.getText(),(Categoria)categoria.getSelectedItem(),modelo))
                    agregarEjemplares();
            }
        });

        JButton cancelar=  new JButton("Cancelar");
        contenedor.add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEjemplares();
            }
        });



        contenedor.validate();
        contenedor.repaint();

    }

    public void verEjemplares(){
        this.actual = EstadoVentanas.VEREJEMPLARES;
        contenedor.removeAll();
        setSize(700,300);
        contenedor.setLayout(new GridLayout(2,1));
        JList<Afiliado> lista = new JList<Afiliado>();
        JButton volver = new JButton("Volver");
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel listModel = new DefaultListModel();
        for(Ejemplar ejem : modelo.getItems().listarEjemplares()){
            if(ejem.getAfiliado()==null)
                listModel.addElement("Id Ejemplar:  "+ejem.getIdEjemplar()+ "    Item: "+ejem.getItem().getIdItem()+"   "+ ejem.getItem().getTitulo()+ " ["+ejem.getItem().getCategoria()+"]  "+"   Estado:   "+ ejem.getEstado() );
            else
                listModel.addElement("Id Ejemplar:  "+ejem.getIdEjemplar()+ "    Item: "+ejem.getItem().getIdItem()+"   "+ ejem.getItem().getTitulo()+ " ["+ejem.getItem().getCategoria()+"]  "+"   Prestado a:   "+ ejem.getAfiliado().getApellido()+ " , "+ ejem.getAfiliado().getNombre());

        }
        lista.setModel(listModel);

        JScrollPane scrollLista;
        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 120,220, 80);
        volver.setSize(100,100);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejemplares();
            }
        });
        contenedor.add(lista);
        contenedor.add(volver);
        contenedor.validate();
        contenedor.repaint();

    }
    public void borrarEjemplar(){
        this.actual = EstadoVentanas.BORRAREJEMPLAR;
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(1,2,15,15));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,30,30));
        superior.add(new JLabel("Ingrese el ID del ejemplar a borrar"));
        //superior.add(new JLabel(""));
        central.add(new JLabel("ID :"));
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
                if(controlador.borrarEjemplar(Integer.parseInt(dni.getText()), modelo))
                ejemplares();

            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ejemplares();

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

    public void darBaja(){
        this.actual = EstadoVentanas.DARBAJA;
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(1,2,15,15));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,30,30));
        superior.add(new JLabel("Ingrese el ID del ejempar a dar de baja"));
        //superior.add(new JLabel(""));
        central.add(new JLabel("ID :"));
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
                if(controlador.darBaja(Integer.parseInt(dni.getText()), modelo))
                    ejemplares();

            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ejemplares();

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
    public void modFecha(){
        this.actual = EstadoVentanas.MODFECHA;
        contenedor.removeAll();
        setSize(300,300);
        contenedor.setLayout(new GridLayout(3,1,30,30));
        JPanel panel1= new JPanel();
        panel1.add(new JLabel("Modificar fecha de la Biblioteca: "));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2,30,30));
        panel2.add(new JLabel("Nueva Fecha "));

        JTextField dni = new JTextField(16);
        dni.setSize(100,10);
        panel2.add(dni);
        dni.addActionListener(new ActionListener() {
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
                if(controlador.setFecha(dni.getText(),modelo))
                    menuBibliotecario();
            }
        });
        panel5.add(aceptar);
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBibliotecario();
            }
        });
        panel5.add(cancelar);
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel5);
        contenedor.validate();
        contenedor.repaint();


    }
    public void prestamos(){
        this.actual = EstadoVentanas.PRESTAMOS;
        contenedor.removeAll();
        setSize(300,300);
        contenedor.setLayout(new GridLayout(4,1,15,15));
        contenedor.add(new JLabel("Acciones sobre Prestamos"));
        JButton prestar = new JButton("Prestar");
        prestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestamo();
            }
        });
        contenedor.add(prestar);
        JButton devolver = new JButton("Devolver");
        devolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolucion();
            }
        });
        contenedor.add(devolver);

        JButton volver = new JButton("Volver");
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBibliotecario();
            }
        });
        contenedor.add(volver);
        contenedor.validate();
        contenedor.repaint();

    }
    public void prestamo(){
        this.actual = EstadoVentanas.PRESTAMO;
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(2,2,0,0));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,20,20));
        superior.add(new JLabel("Ingrese el ID del Afiliado y del Ejemplar"));
        central.add(new JLabel("DNI :"));
        JTextField dni = new JTextField(16);
        dni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(dni);
        central.add(new JLabel("ID Ejemplar: "));
        JTextField contra = new JTextField(16);
        contra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        central.add(contra);
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controlador.prestar(Integer.parseInt(contra.getText()),Integer.parseInt(dni.getText()), modelo))
                    prestamos();

            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                prestamos();

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
    public void devolucion(){
        this.actual = EstadoVentanas.DEVOLUCION;
        contenedor.removeAll();
        setSize(450,200);
        JPanel inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        JPanel superior = new JPanel();
        JPanel central = new JPanel();
        central.setLayout(new GridLayout(1,2,0,0));
        superior.setLayout(new GridLayout(2,1));
        contenedor.setLayout(new GridLayout(3,1,20,20));
        superior.add(new JLabel("Ingrese el ID del Ejemplar"));
        central.add(new JLabel("ID Ejemplar :"));
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
                if(controlador.devolver(Integer.parseInt(dni.getText()),modelo))
                    prestamos();

            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                prestamos();

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
    public void actualizarVentana(){
        switch ( actual){
            case INICIAL: menuInicial();
                break;

            case BIBLIOTECARIO: menuBibliotecario();
                break;
            case LOGOUT: logout();
                break;
            case LOGIN: logIn();
                break;
            case AFILIADOS: Afiliados();
                break;
            case AGREGARAFILIADO: agregarAfiliado();
                break;
            case VERAFILIADOS: verAfiliados();
                break;
            case BORRARAFILIADO: borrarAfiliado();
                break;
            case SUSPENDER: suspender();
                break;
            case MODDATOS: modDatos();
                break;
            case MODPERMISOS: modPermisos();
                break;
            case EJEMPLARES: ejemplares();
                break;
            case AGREGAREJEMPLARES: agregarEjemplares();
                break;
            case AGREGARLIBRO: agregarLibro();
                break;
            case AGREGARREVISTA: agregarRevista();
                break;
            case AGREGARAUDIOV: agregarAudioVisual();
                break;
            case AGREGARTESIS: agregarTesis();
                break;
            case VEREJEMPLARES: verEjemplares();
                break;
            case BORRAREJEMPLAR: borrarEjemplar();
                break;
            case DARBAJA: darBaja();
                break;
            case MODFECHA: modFecha();
                break;
            case PRESTAMOS: prestamos();
                break;
            case PRESTAMO: prestamo();
                break;
            case DEVOLUCION: devolucion();
                break;

        }
/*INICIAL, BIBLIOTECARIO,LOGOUT,LOGIN,AFILIADOS,AGREGARAFILIADO,VERAFILIADOS,BORRARAFILIADO,SUSPENDER,MODDATOS,MODPERMISOS,EJEMPLARES,AGREGAREJEMPLARES,
    AGREGARLIBRO,AGREGARREVISTA,AGREGARAUDIOV,AGREGARTESIS,VEREJEMPLARES,BORRAREJEMPLAR,DARBAJA,MODFECHA */

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
