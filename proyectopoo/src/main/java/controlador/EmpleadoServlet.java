package controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

import dao.EmpleadoDAO;
import modelo.Empleado;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        EmpleadoDAO dao = new EmpleadoDAO();

        // ====== PDF ======
     // ====== PDF ======
        if ("pdf".equals(accion)) {

            response.setContentType("application/pdf");
            response.setHeader(
                "Content-Disposition",
                "attachment; filename=empleados.pdf"
            );

            try {
                Document document = new Document(PageSize.A4);
                PdfWriter.getInstance(document, response.getOutputStream());
                document.open();

                // ====== FUENTES ======
                Font titulo = new Font(Font.HELVETICA, 18, Font.BOLD);
                Font header = new Font(Font.HELVETICA, 12, Font.BOLD);
                Font normal = new Font(Font.HELVETICA, 11);

                // ====== TITULO ======
                Paragraph title = new Paragraph("LISTA DE EMPLEADOS", titulo);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(20);
                document.add(title);

                // ====== TABLA ======
                PdfPTable table = new PdfPTable(5); // columnas
                table.setWidthPercentage(100);
                table.setWidths(new float[]{3, 3, 4, 2, 2});

                // ====== ENCABEZADOS ======
                table.addCell(new PdfPCell(new Phrase("Empleado", header)));
                table.addCell(new PdfPCell(new Phrase("Cargo", header)));
                table.addCell(new PdfPCell(new Phrase("Correo", header)));
                table.addCell(new PdfPCell(new Phrase("Sueldo", header)));
                table.addCell(new PdfPCell(new Phrase("Estado", header)));

                // ====== DATA ======
                List<Empleado> lista = dao.listar();

                for (Empleado e : lista) {
                    table.addCell(new Phrase(
                        e.getNombres() + " " + e.getApellidos(), normal
                    ));
                    table.addCell(new Phrase(e.getCargo(), normal));
                    table.addCell(new Phrase(e.getCorreo(), normal));
                    table.addCell(new Phrase("S/ " + e.getSueldo(), normal));
                    table.addCell(new Phrase(e.getEstado(), normal));
                }

                document.add(table);
                document.close();
                return;

            } catch (Exception ex) {
                throw new ServletException(ex);
            }
        }



        // ====== ELIMINAR ======
        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("EmpleadoServlet");
            return;
        }

        // ====== EDITAR ======
        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Empleado e = dao.obtenerPorId(id);

            request.setAttribute("empleado", e);
            request.getRequestDispatcher("edit_empleado.jsp")
                   .forward(request, response);
            return;
        }

        // ====== LISTAR ======
        request.setAttribute("lista", dao.listar());
        request.getRequestDispatcher("empleados.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        EmpleadoDAO dao = new EmpleadoDAO();

        // ====== GUARDAR ======
        if ("guardar".equals(accion)) {

            Empleado e = new Empleado();
            e.setNombres(request.getParameter("nombres"));
            e.setApellidos(request.getParameter("apellidos"));
            e.setFechaNacimiento(
                java.sql.Date.valueOf(request.getParameter("fechaNacimiento"))
            );
            e.setCorreo(request.getParameter("correo"));
            e.setCargo(request.getParameter("cargo"));
            e.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
            e.setEstado(request.getParameter("estado"));

            dao.insertar(e);
            response.sendRedirect("EmpleadoServlet");
            return;
        }

        // ====== ACTUALIZAR ======
        if ("actualizar".equals(accion)) {

            Empleado e = new Empleado();
            e.setId(Integer.parseInt(request.getParameter("id")));
            e.setNombres(request.getParameter("nombres"));
            e.setApellidos(request.getParameter("apellidos"));
            e.setFechaNacimiento(
                java.sql.Date.valueOf(request.getParameter("fechaNacimiento"))
            );
            e.setCorreo(request.getParameter("correo"));
            e.setCargo(request.getParameter("cargo"));
            e.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
            e.setEstado(request.getParameter("estado"));

            dao.actualizar(e);
            response.sendRedirect("EmpleadoServlet");
        }
    }
}
