package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		this.speedometer = speedometer;
        // valores deberán tomar null
        this.speedLimit = null;
        this.speedSet = null;

	}
	
	/*
	 * Method to code
	 */
	public void setSpeedSet(int speedSet) throws SpeedSetAboveSpeedLimitException, IncorrectSpeedException {
        if (this.speedLimit == null && speedSet < 0 ) {
            throw new IncorrectSpeedException("La velocidad debe ser positiva cuando no hay límite de velocidad establecido");
        }
        if (this.speedLimit != null && speedSet > this.speedLimit) {
            throw new SpeedSetAboveSpeedLimitException("La velocidad establecida no puede superar el límite de velocidad");
        }
        this.speedSet = speedSet;
		
	}

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

}
