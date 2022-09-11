package usecase;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import interfaces.IdGenerator;

public class AnyIdGenerator implements IdGenerator {
    @Override
    public String generate() {
        return generator().generate().toString().replaceAll("-", "");
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }
}
