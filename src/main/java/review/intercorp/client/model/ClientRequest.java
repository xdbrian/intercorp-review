package review.intercorp.client.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


/**
 * Detalle de clientes.
 * @Autor xdbrian.steventh@gmai.com
 */
@Getter
@Setter
@ApiModel(description = "Detalle de clientes")
public class ClientRequest implements Serializable {

    @ApiModelProperty(notes = "Nombre del cliente",example = "Brian",required = true)
    String nombre;

    @ApiModelProperty(notes = "Apellido del cliente",example = "Torres",required = true)
    String apellido;

    @ApiModelProperty(notes = "Edad del cliente",example = "29",required = true)
    Integer edad;

    @ApiModelProperty(notes = "Fecha de nacimiento del cliente",example = "1990-01-01",required = true)
    @Pattern(regexp = "dd/mm/yyyy")
            @Max(value = 10)
    String fechaNacimiento;

}
