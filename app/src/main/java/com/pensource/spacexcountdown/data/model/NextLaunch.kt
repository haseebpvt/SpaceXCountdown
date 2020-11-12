package com.pensource.spacexcountdown.data.model
import com.google.gson.annotations.SerializedName


data class NextLaunch(
    @SerializedName("crew")
    val crew: List<Any>,
    @SerializedName("details")
    val details: Any,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("is_tentative")
    val isTentative: Boolean,
    @SerializedName("last_date_update")
    val lastDateUpdate: String,
    @SerializedName("last_ll_launch_date")
    val lastLlLaunchDate: Any,
    @SerializedName("last_ll_update")
    val lastLlUpdate: Any,
    @SerializedName("last_wiki_launch_date")
    val lastWikiLaunchDate: String,
    @SerializedName("last_wiki_revision")
    val lastWikiRevision: String,
    @SerializedName("last_wiki_update")
    val lastWikiUpdate: String,
    @SerializedName("launch_date_local")
    val launchDateLocal: String,
    @SerializedName("launch_date_source")
    val launchDateSource: String,
    @SerializedName("launch_date_unix")
    val launchDateUnix: Int,
    @SerializedName("launch_date_utc")
    val launchDateUtc: String,
    @SerializedName("launch_site")
    val launchSite: LaunchSite,
    @SerializedName("launch_success")
    val launchSuccess: Any,
    @SerializedName("launch_window")
    val launchWindow: Any,
    @SerializedName("launch_year")
    val launchYear: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("mission_id")
    val missionId: List<String>,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("rocket")
    val rocket: Rocket,
    @SerializedName("ships")
    val ships: List<String>,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Any,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: Any,
    @SerializedName("tbd")
    val tbd: Boolean,
    @SerializedName("telemetry")
    val telemetry: Telemetry,
    @SerializedName("tentative_max_precision")
    val tentativeMaxPrecision: String,
    @SerializedName("timeline")
    val timeline: Any,
    @SerializedName("upcoming")
    val upcoming: Boolean
)

data class LaunchSite(
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("site_name")
    val siteName: String,
    @SerializedName("site_name_long")
    val siteNameLong: String
)

data class Links(
    @SerializedName("article_link")
    val articleLink: Any,
    @SerializedName("flickr_images")
    val flickrImages: List<Any>,
    @SerializedName("mission_patch")
    val missionPatch: Any,
    @SerializedName("mission_patch_small")
    val missionPatchSmall: Any,
    @SerializedName("presskit")
    val presskit: Any,
    @SerializedName("reddit_campaign")
    val redditCampaign: String,
    @SerializedName("reddit_launch")
    val redditLaunch: Any,
    @SerializedName("reddit_media")
    val redditMedia: Any,
    @SerializedName("reddit_recovery")
    val redditRecovery: Any,
    @SerializedName("video_link")
    val videoLink: Any,
    @SerializedName("wikipedia")
    val wikipedia: String,
    @SerializedName("youtube_id")
    val youtubeId: Any
)

data class Rocket(
    @SerializedName("fairings")
    val fairings: Any,
    @SerializedName("first_stage")
    val firstStage: FirstStage,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("second_stage")
    val secondStage: SecondStage
)

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: Any
)

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core>
)

data class SecondStage(
    @SerializedName("block")
    val block: Int,
    @SerializedName("payloads")
    val payloads: List<Payload>
)

data class Core(
    @SerializedName("block")
    val block: Int,
    @SerializedName("core_serial")
    val coreSerial: String,
    @SerializedName("flight")
    val flight: Int,
    @SerializedName("gridfins")
    val gridfins: Boolean,
    @SerializedName("land_success")
    val landSuccess: Any,
    @SerializedName("landing_intent")
    val landingIntent: Boolean,
    @SerializedName("landing_type")
    val landingType: Any,
    @SerializedName("landing_vehicle")
    val landingVehicle: String,
    @SerializedName("legs")
    val legs: Boolean,
    @SerializedName("reused")
    val reused: Boolean
)

data class Payload(
    @SerializedName("cap_serial")
    val capSerial: Any,
    @SerializedName("cargo_manifest")
    val cargoManifest: Any,
    @SerializedName("customers")
    val customers: List<String>,
    @SerializedName("flight_time_sec")
    val flightTimeSec: Any,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("mass_returned_kg")
    val massReturnedKg: Any,
    @SerializedName("mass_returned_lbs")
    val massReturnedLbs: Any,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("norad_id")
    val noradId: List<Any>,
    @SerializedName("orbit")
    val orbit: String,
    @SerializedName("orbit_params")
    val orbitParams: OrbitParams,
    @SerializedName("payload_id")
    val payloadId: String,
    @SerializedName("payload_mass_kg")
    val payloadMassKg: Any,
    @SerializedName("payload_mass_lbs")
    val payloadMassLbs: Any,
    @SerializedName("payload_type")
    val payloadType: String,
    @SerializedName("reused")
    val reused: Boolean
)

data class OrbitParams(
    @SerializedName("apoapsis_km")
    val apoapsisKm: Any,
    @SerializedName("arg_of_pericenter")
    val argOfPericenter: Any,
    @SerializedName("eccentricity")
    val eccentricity: Any,
    @SerializedName("epoch")
    val epoch: Any,
    @SerializedName("inclination_deg")
    val inclinationDeg: Any,
    @SerializedName("lifespan_years")
    val lifespanYears: Any,
    @SerializedName("longitude")
    val longitude: Any,
    @SerializedName("mean_anomaly")
    val meanAnomaly: Any,
    @SerializedName("mean_motion")
    val meanMotion: Any,
    @SerializedName("periapsis_km")
    val periapsisKm: Any,
    @SerializedName("period_min")
    val periodMin: Any,
    @SerializedName("raan")
    val raan: Any,
    @SerializedName("reference_system")
    val referenceSystem: String,
    @SerializedName("regime")
    val regime: String,
    @SerializedName("semi_major_axis_km")
    val semiMajorAxisKm: Any
)