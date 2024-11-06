import java.io.File;

public class RenombrarDirectorios {

    public void renombrarDirecotrios(String path){
        //VALIDEMOS QUE EL PATH SEA UN DIRECOTRIO
        File directorio = new File(path);
        if(!directorio.exists() || !directorio.isDirectory()){
            System.out.println("LA RUTA PATH NO ES UN DIRECTORIO VALIDO");
            return;
        }
        
        // ACA VAMOS A CAMBIAR LOS NOMBRES
        System.out.println("LA RUTA PATH ES VALIDA");
        renombrarDirectorioInterno(directorio);
    }
    public void renombrarDirectorioInterno(File directorio){
        // LISTAR TODOS LOS ARCHIVOS Y/O CARPETAS HIJAS
        File[] direcotriosArchivosInternos = directorio.listFiles();
        if(direcotriosArchivosInternos == null){
            return;
        } 
        for(File direcotrioArchivo : direcotriosArchivosInternos){
            if(direcotrioArchivo.isDirectory()){ //Si es carpeta cambio el nombre
                String nombreOriginal = direcotrioArchivo.getName();
                String nombreNuevo = "Nuevo_"+ nombreOriginal;
                File nuevoDirectorio = new File(direcotrioArchivo.getParent(),nombreNuevo);
                if(direcotrioArchivo.renameTo(nuevoDirectorio)){
                    renombrarDirectorioInterno(nuevoDirectorio);
                }
            }
        }
    }
}
