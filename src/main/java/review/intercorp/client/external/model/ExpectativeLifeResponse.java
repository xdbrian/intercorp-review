package review.intercorp.client.external.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dob",
        "country",
        "total_life_expectancy",
        "sex"
})
public class ExpectativeLifeResponse {

    @JsonProperty("dob")
    private String dob;
    @JsonProperty("country")
    private String country;
    @JsonProperty("total_life_expectancy")
    private Double totalLifeExpectancy;
    @JsonProperty("sex")
    private String sex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dob")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("total_life_expectancy")
    public Double getTotalLifeExpectancy() {
        return totalLifeExpectancy;
    }

    @JsonProperty("total_life_expectancy")
    public void setTotalLifeExpectancy(Double totalLifeExpectancy) {
        this.totalLifeExpectancy = totalLifeExpectancy;
    }

    @JsonProperty("sex")
    public String getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}