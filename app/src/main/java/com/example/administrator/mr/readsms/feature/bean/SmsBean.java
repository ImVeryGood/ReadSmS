package com.example.administrator.mr.readsms.feature.bean;

import java.util.List;

public class SmsBean {

    /**
     * date : 1545726375242
     * number : 17600382536
     * type : send
     * body : 1212112121212121
     */

    private String date;
    private String number;
    private String type;
    private String body;
    /**
     * code : 200
     * msg : 成功
     * result : {"totalWaitPayAmount":1274,"cashApplyWaitPayVOList":[{"applyNo":"AL00000000552018122820042466","period":10,"needTotalRepayAmount":1274,"repaymentBillList":[{"billNo":"BL00000000552018122820044902","currentPeriod":2,"needRepayAmount":147,"overdueTime":"2018-12-27","overdueDays":2,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044903","currentPeriod":3,"needRepayAmount":147,"overdueTime":"2018-12-28","overdueDays":1,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044904","currentPeriod":4,"needRepayAmount":140,"overdueTime":"2018-12-31","overdueDays":-1,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044905","currentPeriod":5,"needRepayAmount":140,"overdueTime":"2019-01-01","overdueDays":-2,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044906","currentPeriod":6,"needRepayAmount":140,"overdueTime":"2019-01-02","overdueDays":-3,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044907","currentPeriod":7,"needRepayAmount":140,"overdueTime":"2019-01-03","overdueDays":-4,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044908","currentPeriod":8,"needRepayAmount":140,"overdueTime":"2019-01-04","overdueDays":-5,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044909","currentPeriod":9,"needRepayAmount":140,"overdueTime":"2019-01-05","overdueDays":-6,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044910","currentPeriod":10,"needRepayAmount":140,"overdueTime":"2019-01-06","overdueDays":-7,"overdue":false,"postpone":false}],"lastDueTime":"2018-12-27","maxOverdueDay":2,"postponeInterestRate":0,"postponeInterest":0,"overdue":false}]}
     * success : true
     */

    private String code;
    private String msg;
    private ResultBean result;
    private boolean success;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class ResultBean {
        /**
         * totalWaitPayAmount : 1274.0
         * cashApplyWaitPayVOList : [{"applyNo":"AL00000000552018122820042466","period":10,"needTotalRepayAmount":1274,"repaymentBillList":[{"billNo":"BL00000000552018122820044902","currentPeriod":2,"needRepayAmount":147,"overdueTime":"2018-12-27","overdueDays":2,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044903","currentPeriod":3,"needRepayAmount":147,"overdueTime":"2018-12-28","overdueDays":1,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044904","currentPeriod":4,"needRepayAmount":140,"overdueTime":"2018-12-31","overdueDays":-1,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044905","currentPeriod":5,"needRepayAmount":140,"overdueTime":"2019-01-01","overdueDays":-2,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044906","currentPeriod":6,"needRepayAmount":140,"overdueTime":"2019-01-02","overdueDays":-3,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044907","currentPeriod":7,"needRepayAmount":140,"overdueTime":"2019-01-03","overdueDays":-4,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044908","currentPeriod":8,"needRepayAmount":140,"overdueTime":"2019-01-04","overdueDays":-5,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044909","currentPeriod":9,"needRepayAmount":140,"overdueTime":"2019-01-05","overdueDays":-6,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044910","currentPeriod":10,"needRepayAmount":140,"overdueTime":"2019-01-06","overdueDays":-7,"overdue":false,"postpone":false}],"lastDueTime":"2018-12-27","maxOverdueDay":2,"postponeInterestRate":0,"postponeInterest":0,"overdue":false}]
         */

        private double totalWaitPayAmount;
        private List<CashApplyWaitPayVOListBean> cashApplyWaitPayVOList;

        public double getTotalWaitPayAmount() {
            return totalWaitPayAmount;
        }

        public void setTotalWaitPayAmount(double totalWaitPayAmount) {
            this.totalWaitPayAmount = totalWaitPayAmount;
        }

        public List<CashApplyWaitPayVOListBean> getCashApplyWaitPayVOList() {
            return cashApplyWaitPayVOList;
        }

        public void setCashApplyWaitPayVOList(List<CashApplyWaitPayVOListBean> cashApplyWaitPayVOList) {
            this.cashApplyWaitPayVOList = cashApplyWaitPayVOList;
        }

        public static class CashApplyWaitPayVOListBean {
            /**
             * applyNo : AL00000000552018122820042466
             * period : 10
             * needTotalRepayAmount : 1274.0
             * repaymentBillList : [{"billNo":"BL00000000552018122820044902","currentPeriod":2,"needRepayAmount":147,"overdueTime":"2018-12-27","overdueDays":2,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044903","currentPeriod":3,"needRepayAmount":147,"overdueTime":"2018-12-28","overdueDays":1,"overdue":true,"postpone":false},{"billNo":"BL00000000552018122820044904","currentPeriod":4,"needRepayAmount":140,"overdueTime":"2018-12-31","overdueDays":-1,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044905","currentPeriod":5,"needRepayAmount":140,"overdueTime":"2019-01-01","overdueDays":-2,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044906","currentPeriod":6,"needRepayAmount":140,"overdueTime":"2019-01-02","overdueDays":-3,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044907","currentPeriod":7,"needRepayAmount":140,"overdueTime":"2019-01-03","overdueDays":-4,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044908","currentPeriod":8,"needRepayAmount":140,"overdueTime":"2019-01-04","overdueDays":-5,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044909","currentPeriod":9,"needRepayAmount":140,"overdueTime":"2019-01-05","overdueDays":-6,"overdue":false,"postpone":false},{"billNo":"BL00000000552018122820044910","currentPeriod":10,"needRepayAmount":140,"overdueTime":"2019-01-06","overdueDays":-7,"overdue":false,"postpone":false}]
             * lastDueTime : 2018-12-27
             * maxOverdueDay : 2
             * postponeInterestRate : 0.0
             * postponeInterest : 0.0
             * overdue : false
             */

            private String applyNo;
            private int period;
            private double needTotalRepayAmount;
            private String lastDueTime;
            private int maxOverdueDay;
            private double postponeInterestRate;
            private double postponeInterest;
            private boolean overdue;
            private List<RepaymentBillListBean> repaymentBillList;

            public String getApplyNo() {
                return applyNo;
            }

            public void setApplyNo(String applyNo) {
                this.applyNo = applyNo;
            }

            public int getPeriod() {
                return period;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public double getNeedTotalRepayAmount() {
                return needTotalRepayAmount;
            }

            public void setNeedTotalRepayAmount(double needTotalRepayAmount) {
                this.needTotalRepayAmount = needTotalRepayAmount;
            }

            public String getLastDueTime() {
                return lastDueTime;
            }

            public void setLastDueTime(String lastDueTime) {
                this.lastDueTime = lastDueTime;
            }

            public int getMaxOverdueDay() {
                return maxOverdueDay;
            }

            public void setMaxOverdueDay(int maxOverdueDay) {
                this.maxOverdueDay = maxOverdueDay;
            }

            public double getPostponeInterestRate() {
                return postponeInterestRate;
            }

            public void setPostponeInterestRate(double postponeInterestRate) {
                this.postponeInterestRate = postponeInterestRate;
            }

            public double getPostponeInterest() {
                return postponeInterest;
            }

            public void setPostponeInterest(double postponeInterest) {
                this.postponeInterest = postponeInterest;
            }

            public boolean isOverdue() {
                return overdue;
            }

            public void setOverdue(boolean overdue) {
                this.overdue = overdue;
            }

            public List<RepaymentBillListBean> getRepaymentBillList() {
                return repaymentBillList;
            }

            public void setRepaymentBillList(List<RepaymentBillListBean> repaymentBillList) {
                this.repaymentBillList = repaymentBillList;
            }

            public static class RepaymentBillListBean {
                /**
                 * billNo : BL00000000552018122820044902
                 * currentPeriod : 2
                 * needRepayAmount : 147.0
                 * overdueTime : 2018-12-27
                 * overdueDays : 2
                 * overdue : true
                 * postpone : false
                 */

                private String billNo;
                private int currentPeriod;
                private double needRepayAmount;
                private String overdueTime;
                private int overdueDays;
                private boolean overdue;
                private boolean postpone;

                public String getBillNo() {
                    return billNo;
                }

                public void setBillNo(String billNo) {
                    this.billNo = billNo;
                }

                public int getCurrentPeriod() {
                    return currentPeriod;
                }

                public void setCurrentPeriod(int currentPeriod) {
                    this.currentPeriod = currentPeriod;
                }

                public double getNeedRepayAmount() {
                    return needRepayAmount;
                }

                public void setNeedRepayAmount(double needRepayAmount) {
                    this.needRepayAmount = needRepayAmount;
                }

                public String getOverdueTime() {
                    return overdueTime;
                }

                public void setOverdueTime(String overdueTime) {
                    this.overdueTime = overdueTime;
                }

                public int getOverdueDays() {
                    return overdueDays;
                }

                public void setOverdueDays(int overdueDays) {
                    this.overdueDays = overdueDays;
                }

                public boolean isOverdue() {
                    return overdue;
                }

                public void setOverdue(boolean overdue) {
                    this.overdue = overdue;
                }

                public boolean isPostpone() {
                    return postpone;
                }

                public void setPostpone(boolean postpone) {
                    this.postpone = postpone;
                }
            }
        }
    }
}
