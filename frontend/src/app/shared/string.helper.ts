export function toUpper(string: string): string {
  if (string) {
    return string.toUpperCase()
  }
  return string
}

export function formatDateSQL(data) {
  if (data) {
    data = data.replace(/\//g, '')
    return data ? data.substring(4, 6 + data.length - 6) + '-' + data.substring(2, 4) + '-' + data.substring(0, 2) : data
  } else return ""
}

export function formatSQLDate(data) {
  if (data) {
    data = data.replace(/\//g, '')
    return data ? data.substring(8, 10) + '/' + data.substring(5, 7) + '/' + data.substring(0, 4) : data
  } else return ""
}

export function formatCPF(string:string):string {
  return string ? string.substring(0, 3) + '.' + string.substring(3, 6) + '.' + string.substring(6, 9) + '-'+string.substring(9, 11) : string
}
