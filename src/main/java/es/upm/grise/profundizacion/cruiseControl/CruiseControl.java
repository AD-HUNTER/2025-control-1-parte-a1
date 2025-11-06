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
            this.speedSet = null;
            throw new IncorrectSpeedException("La velocidad debe ser positiva cuando no hay límite de velocidad establecido");
        } else if (this.speedLimit != null && speedSet > this.speedLimit) {
            this.speedSet = null;
            throw new SpeedSetAboveSpeedLimitException("La velocidad establecida no puede superar el límite de velocidad");
        } else {
            this.speedSet = speedSet;
        }
		
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