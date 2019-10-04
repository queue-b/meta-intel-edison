SUMMARY = "U-Boot bootloader image creation tool"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
SECTION = "bootloader"

DEPENDS = "openssl bison"

require u-boot-common_${PV}.inc

EXTRA_OEMAKE = 'HOSTCC="${CC}" HOSTLD="${LD}" HOST_CFLAGS="${CFLAGS}" HOSTLDFLAGS="${LDFLAGS}" HOSTSTRIP=true'

do_compile () {
	oe_runmake edison_defconfig
	oe_runmake cross_tools NO_SDL=1
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 tools/mkimage ${D}${bindir}/uboot-mkimage
	ln -sf uboot-mkimage ${D}${bindir}/mkimage
}

BBCLASSEXTEND = "native nativesdk"

SUMMARY = "U-Boot bootloader image creation tool"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
SECTION = "bootloader"

DEPENDS = "openssl bison"
