package org.springframework.samples.petclinic.owner;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "owners_contact")
public class OwnerContact {

	@Id
	@Column(name = "owner_id")
	private Integer ownerId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@NotBlank
	@Column(name = "address")
	private String address;

	@NotBlank
	@Column(name = "city")
	private String city;

	@NotBlank
	@Pattern(regexp = "\\d{10}", message = "{telephone.invalid}")
	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;
}
