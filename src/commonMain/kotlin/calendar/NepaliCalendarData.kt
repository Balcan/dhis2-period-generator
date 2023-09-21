package calendar

val NEPALI_CALENDAR_DATA = mapOf(
    1970 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1971 to intArrayOf(18, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30),
    1972 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
    1973 to intArrayOf(19, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    1974 to intArrayOf(19, 31, 31, 32, 30, 31, 31, 30, 29, 30, 29, 30, 30),
    1975 to intArrayOf(18, 31, 31, 32, 32, 30, 31, 30, 29, 30, 29, 30, 30),
    1976 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    1977 to intArrayOf(18, 31, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31),
    1978 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1979 to intArrayOf(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
    1980 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    1981 to intArrayOf(18, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
    1982 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1983 to intArrayOf(18, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
    1984 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    1985 to intArrayOf(18, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
    1986 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1987 to intArrayOf(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30),
    1988 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    1989 to intArrayOf(18, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
    1990 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1991 to intArrayOf(18, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30),
    1992 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    1993 to intArrayOf(18, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
    1994 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1995 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
    1996 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    1997 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1998 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    1999 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2000 to intArrayOf(17, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2001 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2002 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2003 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2004 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2005 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2006 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2007 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2008 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2009 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2010 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2011 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2012 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2013 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2014 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2015 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2016 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2017 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2018 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2019 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2020 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2021 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2022 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2023 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2024 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2025 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2026 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2027 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2028 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2029 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2030 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2031 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2032 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2033 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2034 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2035 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2036 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
    2037 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2038 to intArrayOf(18, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
    2039 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
    2040 to intArrayOf(17, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31)
)
