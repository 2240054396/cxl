package com.zlt.entity;

import java.util.ArrayList;
import java.util.List;

public class IndustryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndustryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIidIsNull() {
            addCriterion("iid is null");
            return (Criteria) this;
        }

        public Criteria andIidIsNotNull() {
            addCriterion("iid is not null");
            return (Criteria) this;
        }

        public Criteria andIidEqualTo(Long value) {
            addCriterion("iid =", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotEqualTo(Long value) {
            addCriterion("iid <>", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThan(Long value) {
            addCriterion("iid >", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThanOrEqualTo(Long value) {
            addCriterion("iid >=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThan(Long value) {
            addCriterion("iid <", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThanOrEqualTo(Long value) {
            addCriterion("iid <=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidIn(List<Long> values) {
            addCriterion("iid in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotIn(List<Long> values) {
            addCriterion("iid not in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidBetween(Long value1, Long value2) {
            addCriterion("iid between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotBetween(Long value1, Long value2) {
            addCriterion("iid not between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andInameIsNull() {
            addCriterion("iname is null");
            return (Criteria) this;
        }

        public Criteria andInameIsNotNull() {
            addCriterion("iname is not null");
            return (Criteria) this;
        }

        public Criteria andInameEqualTo(String value) {
            addCriterion("iname =", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameNotEqualTo(String value) {
            addCriterion("iname <>", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameGreaterThan(String value) {
            addCriterion("iname >", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameGreaterThanOrEqualTo(String value) {
            addCriterion("iname >=", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameLessThan(String value) {
            addCriterion("iname <", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameLessThanOrEqualTo(String value) {
            addCriterion("iname <=", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameLike(String value) {
            addCriterion("iname like", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameNotLike(String value) {
            addCriterion("iname not like", value, "iname");
            return (Criteria) this;
        }

        public Criteria andInameIn(List<String> values) {
            addCriterion("iname in", values, "iname");
            return (Criteria) this;
        }

        public Criteria andInameNotIn(List<String> values) {
            addCriterion("iname not in", values, "iname");
            return (Criteria) this;
        }

        public Criteria andInameBetween(String value1, String value2) {
            addCriterion("iname between", value1, value2, "iname");
            return (Criteria) this;
        }

        public Criteria andInameNotBetween(String value1, String value2) {
            addCriterion("iname not between", value1, value2, "iname");
            return (Criteria) this;
        }

        public Criteria andIdescIsNull() {
            addCriterion("idesc is null");
            return (Criteria) this;
        }

        public Criteria andIdescIsNotNull() {
            addCriterion("idesc is not null");
            return (Criteria) this;
        }

        public Criteria andIdescEqualTo(String value) {
            addCriterion("idesc =", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescNotEqualTo(String value) {
            addCriterion("idesc <>", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescGreaterThan(String value) {
            addCriterion("idesc >", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescGreaterThanOrEqualTo(String value) {
            addCriterion("idesc >=", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescLessThan(String value) {
            addCriterion("idesc <", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescLessThanOrEqualTo(String value) {
            addCriterion("idesc <=", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescLike(String value) {
            addCriterion("idesc like", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescNotLike(String value) {
            addCriterion("idesc not like", value, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescIn(List<String> values) {
            addCriterion("idesc in", values, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescNotIn(List<String> values) {
            addCriterion("idesc not in", values, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescBetween(String value1, String value2) {
            addCriterion("idesc between", value1, value2, "idesc");
            return (Criteria) this;
        }

        public Criteria andIdescNotBetween(String value1, String value2) {
            addCriterion("idesc not between", value1, value2, "idesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}