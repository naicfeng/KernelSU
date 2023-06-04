package org.cuojue.ksu.profile

/**
 * @author weishu
 * @date 2023/6/3.
 */
enum class Groups(val gid: Int, val display: String, val desc: String) {
    ROOT(0, "root", "traditional unix root user"),
    DAEMON(1, "daemon", "Traditional unix daemon owner."),
    BIN(2, "bin", "Traditional unix binaries owner."),
    SYS(3, "sys", "A group with the same gid on Linux/macOS/Android."),
    SYSTEM(1000, "system", "system server"),
    RADIO(1001, "radio", "telephony subsystem, RIL"),
    BLUETOOTH(1002, "bluetooth", "bluetooth subsystem"),
    GRAPHICS(1003, "graphics", "graphics devices"),
    INPUT(1004, "input", "input devices"),
    AUDIO(1005, "audio", "audio devices"),
    CAMERA(1006, "camera", "camera devices"),
    LOG(1007, "log", "log devices"),
    COMPASS(1008, "compass", "compass device"),
    MOUNT(1009, "mount", "mountd socket"),
    WIFI(1010, "wifi", "wifi subsystem"),
    ADB(1011, "adb", "android debug bridge (adbd)"),
    INSTALL(1012, "install", "group for installing packages"),
    MEDIA(1013, "media", "mediaserver process"),
    DHCP(1014, "dhcp", "dhcp client"),
    SDCARD_RW(1015, "sdcard_rw", "external storage write access"),
    VPN(1016, "vpn", "vpn system"),
    KEYSTORE(1017, "keystore", "keystore subsystem"),
    USB(1018, "usb", "USB devices"),
    DRM(1019, "drm", "DRM server"),
    MDNSR(1020, "mdnsr", "MulticastDNSResponder (service discovery)"),
    GPS(1021, "gps", "GPS daemon"),
    UNUSED1(1022, "unused1", "deprecated, DO NOT USE"),
    MEDIA_RW(1023, "media_rw", "internal media storage write access"),
    MTP(1024, "mtp", "MTP USB driver access"),
    UNUSED2(1025, "unused2", "deprecated, DO NOT USE"),
    DRMRPC(1026, "drmrpc", "group for drm rpc"),
    NFC(1027, "nfc", "nfc subsystem"),
    SDCARD_R(1028, "sdcard_r", "external storage read access"),
    CLAT(1029, "clat", "clat part of nat464"),
    LOOP_RADIO(1030, "loop_radio", "loop radio devices"),
    MEDIA_DRM(1031, "media_drm", "MediaDrm plugins"),
    PACKAGE_INFO(1032, "package_info", "access to installed package details"),
    SDCARD_PICS(1033, "sdcard_pics", "external storage photos access"),
    SDCARD_AV(1034, "sdcard_av", "external storage audio/video access"),
    SDCARD_ALL(1035, "sdcard_all", "access all users external storage"),
    LOGD(1036, "logd", "log daemon"),
    SHARED_RELRO(1037, "shared_relro", "creator of shared GNU RELRO files"),
    DBUS(1038, "dbus", "dbus-daemon IPC broker process"),
    TLSDATE(1039, "tlsdate", "tlsdate unprivileged user"),
    MEDIA_EX(1040, "media_ex", "mediaextractor process"),
    AUDIOSERVER(1041, "audioserver", "audioserver process"),
    METRICS_COLL(1042, "metrics_coll", "metrics_collector process"),
    METRICSD(1043, "metricsd", "metricsd process"),
    WEBSERV(1044, "webserv", "webservd process"),
    DEBUGGERD(1045, "debuggerd", "debuggerd unprivileged user"),
    MEDIA_CODEC(1046, "media_codec", "media_codec process"),
    CAMERASERVER(1047, "cameraserver", "cameraserver process"),
    FIREWALL(1048, "firewall", "firewall process"),
    TRUNKS(1049, "trunks", "trunksd process"),
    NVRAM(1050, "nvram", "nvram daemon"),
    DNS_TETHER(1051, "dns_tether", "dns_tether device"),
    DNS_TETHER_RESERVED(1052, "dns_tether_reserved", "Reserved range for dns_tether"),
    WEBVIEW_ZYGOTE(1053, "webview_zygote", "zygote process"),
    WEBVIEW_USER(1054, "webview_user", "webview chromium user"),
    ETHERNET(1055, "ethernet", "Ethernet"),
    TOMBSTONED(1056, "tombstoned", "tombstoned process"),
    GRAPHICS_RW(1057, "graphics_rw", "graphics devices"),

    SHELL(2000, "shell", "adb and debug shell user"),
    CACHE(2001, "cache", "cache access"),
    DIAG(2002, "diag", "diagnostics"),
    NET_BT_ADMIN(3001, "net_bt_admin", "bluetooth: create any socket"),
    NET_BT(3002, "net_bt", "bluetooth: create sco, rfcomm or l2cap sockets"),
    INET(3003, "inet", "can create AF_INET and AF_INET6 sockets"),
    NET_RAW(3004, "net_raw", "can create raw INET sockets"),
    NET_ADMIN(3005, "net_admin", "can configure interfaces and routing tables."),
    NET_BW_STATS(3006, "net_bw_stats", "read bandwidth statistics"),
    NET_BW_ACCT(3007, "net_bw_acct", "change bandwidth statistics accounting"),
    NET_BT_STACK(3008, "net_bt_stack", "access to various bluetooth management functions"),
    QCOM_DIAG(3009, "qcom_diag", "allow msm specific diag commands"),
    EVERYBODY(9997, "everybody", "Shared external storage read/write"),
    MISC(9998, "misc", "Access to misc storage"),
    NOBODY(9999, "nobody", "Reserved"),
    APP(10000, "app", "Access to app data"),
}