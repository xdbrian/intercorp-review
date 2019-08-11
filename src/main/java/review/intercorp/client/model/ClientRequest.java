package review.intercorp.client.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(1)
    @Max(150)
    Integer edad;

    @ApiModelProperty(notes = "Fecha de nacimiento del cliente",example = "1990-01-01",required = true)
    @Pattern(regexp = "^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")
    String fechaNacimiento;

    @ApiModelProperty(notes = "Fecha de nacimiento del cliente",example = "MASCULINO ó FEMENINO",required = true)
    @Pattern(regexp = "(MASCULINO|FEMENINO)$")
    String sexo;

}
