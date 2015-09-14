package com.speedment.beacon;

import com.speedment.Speedment;
import com.speedment.internal.core.code.MainGenerator;
import com.speedment.config.Project;
import com.speedment.internal.core.config.utils.GroovyParser;
import com.speedment.internal.core.platform.SpeedmentFactory;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author pemi
 */
public class Generate {

    public static void main(String[] args) throws IOException {
        final Speedment speedment = SpeedmentFactory.newSpeedmentInstance();
        final Project p = GroovyParser.projectFromGroovy(speedment, Paths.get("src/main/groovy/", "speedment.groovy"));
        final MainGenerator instance = new MainGenerator(speedment);
        instance.accept(p);
    }

}
