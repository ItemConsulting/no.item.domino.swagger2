package io.swagger.parser.util;

import org.eclipse.core.runtime.Path;

import no.item.domino.swagger.wink.util.Util;

//import java.nio.file.Path;
//import java.nio.file.Paths;

public class PathUtils {

    public static Path getParentDirectoryOfFile(String fileStr) {
    	Path file = (Path) new Path(fileStr).makeAbsolute().removeLastSegments(1);
    	Util.debug("Parent directory : " + file.toOSString());
        //Path file = Paths.get(fileStr).toAbsolutePath();
        //return file.toAbsolutePath().getParent();
    	return file;
    }
}
